package au.com.adszew.okitransport.view.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

import au.com.adszew.okitransport.view.model.RouteSearchViewModel;

/**
 * Retrieves a list of stop names that can be displayed to the user.
 */
public class StopNameAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {

    private final ArrayList<String> mStopNames;

    private final int mLimit;

    private RouteSearchViewModel mViewModel;

    /**
     * Creates a new Adapter that will be used to display suggestions as the user types.
     *
     * @param context
     *      The application context.
     * @param resourceId
     *      The resource Id of the component that will
     * @param limit
     *      The number of items to retrieve when performing a search.
     */
    public StopNameAutoCompleteAdapter(final Context context, int resourceId, int limit) {
        super(context, resourceId);
        mStopNames = new ArrayList<String>();
        mLimit     = limit;
    }

    /**
     * Sets the View Model that will be used to perform the actual search.
     *
     * @param viewModel
     *      The View Model that will be used to perform the actual search.
     */
    public void setViewModel(final RouteSearchViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    /**
     * Returns the total number of items currently stored in the  adapter.
     *
     * @return
     *      The total number of items currently stored in the  adapter.
     */
    @Override
    public int getCount() {
        return mStopNames.size();
    }

    /**
     * Returns the item at the specified position.
     *
     * @param index
     *      The index of the item to retrieve.
     * @return
     *      The value of the item at the specified index.
     */
    @Override
    public String getItem(int index) {
        return mStopNames.get(index);
    }

    /**
     * Builds a filter that will be used to execute a search for stops that match a suggestion
     * and will return a list of items that match query.
     *
     * @return
     *      A filter that will be used to execute a search for stops that match a suggestion
     *      and will return a list of items that match query.
     */
    @Override
    public Filter getFilter() {
        final Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults filterResults = new FilterResults();
                if(constraint != null && mViewModel != null) {
                    mStopNames.clear();
                    mStopNames.addAll(mViewModel.getSuggestions(constraint.toString(), mLimit));
                    filterResults.values = mStopNames;
                    filterResults.count  = mStopNames.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(final CharSequence constraint, final FilterResults results) {
                if(results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }
}


