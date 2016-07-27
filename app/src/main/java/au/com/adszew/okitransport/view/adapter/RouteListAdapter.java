package au.com.adszew.okitransport.view.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import au.com.adszew.okitransport.R;
import au.com.adszew.okitransport.model.Route;

/**
 * An adapter for translating a list of Route domain objects into a displayable list.
 */
public class RouteListAdapter extends ArrayAdapter<String> {

    private final List<String> mList;

    /**
     * Creates a new RouteListAdapter to allow the display and selection of a list of items.
     *
     * @param context
     *          The application's context.
     * @param id
     *          The id of the TextView resource.
     */
    public RouteListAdapter(final Activity context, int id) {
        super(context, id, R.id.route_list_label);
        this.mList = new ArrayList<String>();
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);
        if (view != null && !mList.isEmpty()) {
            final String selected = mList.get(position);
            final TextView routeName = (TextView) view.findViewById(R.id.route_list_label);
            routeName.setText(selected);
        }
        return view;
    }
}
