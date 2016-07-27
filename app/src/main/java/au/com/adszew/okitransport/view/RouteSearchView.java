package au.com.adszew.okitransport.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Observable;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import au.com.adszew.okitransport.R;
import au.com.adszew.okitransport.bus.EventBus;
import au.com.adszew.okitransport.events.FragmentTransitionEvent;
import au.com.adszew.okitransport.view.adapter.RouteListAdapter;
import au.com.adszew.okitransport.view.adapter.StopNameAutoCompleteAdapter;
import au.com.adszew.okitransport.view.model.RouteSearchViewModel;

/**
 * Represents a screen that allows a user to select a origin and destination in order to search
 * for a route between these two locations.
 */
public class RouteSearchView extends BaseFragment {

    private static final String VIEW_MODEL_PARAM = "RouteSearchView.ViewModel";
    /**
     * The number of items to display in the search hints for the origin
     * and destination text boxes.
     */
    private static final int SEARCH_HINT_ITEMS_TO_DISPLAY = 5;

    @Bind(R.id.search_origin)
    AutoCompleteTextView mSearchOrigin;

    @Bind(R.id.search_destination)
    AutoCompleteTextView mSearchDestination;

    @Bind(R.id.search_perform_search)
    Button mPerformSearch;

    @Bind(R.id.route_list_view)
    ListView mSearchResults;

    private RouteListAdapter     mListAdapter;
    private RouteSearchViewModel mViewModel;

    /**
     * Creates a new instance of the fragment, passing any parameters required in a Bundle.
     */
    public static RouteSearchView newInstance(final RouteSearchViewModel viewModel) {
        final RouteSearchView fragment = new RouteSearchView();
        Bundle args = new Bundle();
        args.putSerializable(VIEW_MODEL_PARAM, viewModel);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Called when the user enters text, and updates the origin text in the ViewModel.
     */
    @OnTextChanged(R.id.search_origin)
    public void updateOriginText() {
        mViewModel.setOrigin(mSearchOrigin.getText().toString());
    }

    /**
     * Called when the user enters text, and updates the destination text in the ViewModel.
     */
    @OnTextChanged(R.id.search_destination)
    public void updateDestinationText() {
        mViewModel.setDestination(mSearchDestination.getText().toString());
    }

    /**
     * Called when the user clicks the search button. Requests the ViewModel to actually
     * start the search and notify the view when it is complete.
     */
    @OnClick(R.id.search_perform_search)
    public void performSearch() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                mViewModel.performSearch();
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                synchroniseView();
            }
        }.execute();
    }

    /**
     * Synchronises the data that is stored in the ViewModel with the data that is stored
     * in the view.
     */
    public void synchroniseView() {
        final List<String> results = mViewModel.getSearchResults();
        mListAdapter.clear();
        mListAdapter.addAll(results);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable(VIEW_MODEL_PARAM, mViewModel);
        super.onSaveInstanceState(outState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Observable observable, Object data) {
        synchroniseView();
    }

    /**
     * When the user scrolls the next batch of results will be retrieved.
     *
     * <em>Note:</em> The implementation is quite simplistic in that new items are just added,
     * rather than recycling views when possible.
     */
    private class ResultScrollListener implements AbsListView.OnScrollListener {

        private int currentVisibleItemCount;
        private int currentScrollState;
        private int currentFirstVisibleItem;
        private int totalItems;

        /**
         * {@inheritDoc}
         */
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            this.currentFirstVisibleItem = firstVisibleItem;
            this.currentVisibleItemCount = visibleItemCount;
            this.totalItems = totalItemCount;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            this.currentScrollState = scrollState;
            if (totalItems - currentFirstVisibleItem == currentVisibleItemCount
                    && this.currentScrollState == SCROLL_STATE_IDLE) {
                mViewModel.setOffset(totalItems);
                performSearch();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mViewModel = getFromBundle(VIEW_MODEL_PARAM, RouteSearchViewModel.class, savedInstanceState);
        } else {
            mViewModel = getFromBundle(VIEW_MODEL_PARAM, RouteSearchViewModel.class, getArguments());
        }
        if (mViewModel == null) {
            mViewModel = new RouteSearchViewModel();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_route_search, container, false);

        ButterKnife.bind(this, view);

        // Configure adapters for search results
        mListAdapter = new RouteListAdapter(getActivity(), R.layout.route_list_layout);

        mSearchResults.setAdapter(mListAdapter);
        mSearchResults.setOnScrollListener(new ResultScrollListener());
        mSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        mViewModel.setSelected(position);
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void aVoid) {
                        EventBus.getInstance().post(new FragmentTransitionEvent(
                                FragmentTransitionEvent.TransitionType.ROUTE_SUMMARY));

                    }
                }.execute();
            }
        });

        // Configure auto-completion for fields
        StopNameAutoCompleteAdapter stopNameAdapter =
                new StopNameAutoCompleteAdapter(getContext(),
                        R.layout.autocomplete_layout, SEARCH_HINT_ITEMS_TO_DISPLAY);
        stopNameAdapter.setViewModel(mViewModel);
        mSearchDestination.setAdapter(stopNameAdapter);
        mSearchOrigin.setAdapter(stopNameAdapter);

        configureKeyboard(view);

        // Synchronise data; this is particularly important if the view is recreated.
        synchroniseView();

        return view;
    }
}
