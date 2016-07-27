package au.com.adszew.okitransport.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Observable;

import butterknife.Bind;
import butterknife.ButterKnife;
import au.com.adszew.okitransport.R;
import au.com.adszew.okitransport.view.model.RouteDetailViewModel;

/**
 * Represents the details of the route, such as name, total cost, and stops.
 */
public class RouteDetailView extends BaseFragment {

    private static final String VIEW_MODEL_PARAM = "RouteDetailView.ViewModel";

    private RouteDetailViewModel mViewModel;

    @Bind(R.id.route_detail_summary) TableLayout mRouteDetails;
    @Bind(R.id.route_name)           TextView    mRouteName;
    @Bind(R.id.is_accessible_text)   TextView    mAccessibilityText;
    @Bind(R.id.route_cost_text)      TextView    mRouteCostText;


    /**
     * Creates a new instance of the fragment, passing any parameters required in a Bundle.
     */
    public static RouteDetailView newInstance(final RouteDetailViewModel viewModel) {
        final RouteDetailView fragment = new RouteDetailView();
        Bundle args = new Bundle();
        args.putSerializable(VIEW_MODEL_PARAM, viewModel);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mViewModel = getFromBundle(VIEW_MODEL_PARAM, RouteDetailViewModel.class, savedInstanceState);
        } else {
            mViewModel = getFromBundle(VIEW_MODEL_PARAM, RouteDetailViewModel.class, getArguments());
        }
        if (mViewModel == null) {
            mViewModel = new RouteDetailViewModel();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Observable observable, Object data) {
        synchroniseView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(VIEW_MODEL_PARAM, mViewModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_route_detail, container, false);
        ButterKnife.bind(this, view);

        synchroniseView();

        return view;
    }

    /**
     * Synchronises data in the view with the data in the view model.
     */
    private void synchroniseView() {
        mRouteName.setText(mViewModel.getRouteName());
        mAccessibilityText.setText(mViewModel.getRouteAccessibility());
        mRouteCostText.setText(mViewModel.getCost());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
