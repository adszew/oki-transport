package au.com.adszew.okitransport.view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.com.adszew.okitransport.bus.EventBus;
import au.com.adszew.okitransport.domain.RouteQueryController;
import au.com.adszew.okitransport.events.RouteSelectedEvent;
import au.com.adszew.okitransport.model.Route;
import au.com.adszew.okitransport.model.Stop;

/**
 * Represents the data that will be displayed to the user when searching.
 */
public class RouteSearchViewModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_RESULTS_TO_RETRIEVE = 10;

    private String                         mDestination;
    private String                         mOrigin;
    private List<RouteEntry>               mRoutes;
    private int                            mOffset;
    private boolean                        mSearchInvalidated;

    /**
     * Internal class for holding the model and associated description (which will be displayed).
     */
    private static class RouteEntry implements Serializable {
        private String routeId;
        private String description;
    }

    /**
     * Creates a new view model instance with an empty origin and destination and
     * not routes currently selected.
     */
    public RouteSearchViewModel() {
        mDestination          = "";
        mOrigin               = "";
        mRoutes               = new ArrayList<RouteEntry>();
        mOffset               = 0;
        mSearchInvalidated    = true;
    }

    /**
     * Performs the search, using the data that is contained in the ViewModel.
     */
    public void performSearch() {
        if (mSearchInvalidated) {
            resetSearch();
            mSearchInvalidated = false;
        }
        final RouteQueryController controller = new RouteQueryController();
        final List<Route> routes =
                controller.searchForRoutes(mOrigin, mDestination, mOffset, DEFAULT_RESULTS_TO_RETRIEVE);
        for (final Route route : routes) {
            final RouteEntry entry = new RouteEntry();
            entry.routeId     = route.getId();
            entry.description = String.format("%s - %s", route.getRouteName(), route.getOperator());
            mRoutes.add(entry);
        }
    }

    /**
     * Resets the search.
     */
    private void resetSearch() {
        mOffset = 0;
        mRoutes.clear();
    }

    /**
     * Returns the current offset to retrieve the results from.
     *
     * @return
     *      The current offset to retrieve the results from.
     */
    public int getOffset() {
        return mOffset;
    }

    /**
     * Set the offset to retrieve the results from.
     *
     * @param offset
     *      The offset to retrieve the results from.
     */
    public void setOffset(int offset) {
        this.mOffset = offset;
    }

    /**
     * Selects the item that was selected by the user. This initiates an event which allows
     * another component to manage a transition to a different fragment.
     *
     * @param index
     *      The index of the selected item.
     */
    public void setSelected(int index) {
        if (!mRoutes.isEmpty() && index >= 0 && index < mRoutes.size()) {
            final RouteEntry entry = mRoutes.get(index);
            EventBus.getInstance().post(new RouteSelectedEvent(entry.routeId));
        }
    }

    /**
     * Returns a list of suggestions that match Route stops, as the user types.
     *
     * @param hint
     *      The partial name of the stop to search for.
     * @param limit
     *      The number of items to retrieve.
     * @return
     *      A list of stop names that partially match the hint.
     */
    public List<String> getSuggestions(final String hint, int limit) {
        final RouteQueryController controller = new RouteQueryController();
        final List<Stop> stops = controller.searchForStops(hint, limit);
        final List<String> result = new ArrayList<String>(stops.size());
        for (final Stop stop : stops) {
            result.add(stop.getName());
        }
        return result;
    }

    /**
     * Returns the origin of the journey.
     *
     * @return
     *      The origin of the journey.
     */
    public String getOrigin() {
        return mOrigin;
    }


    /**
     * Sets the name of the origin of the journey.
     *
     * @param origin
     *      The name of the origin of the journey.
     */
    public void setOrigin(final String origin) {
        if (origin != null && !origin.equals(mOrigin)) {
            this.mSearchInvalidated = true;
        }
        this.mOrigin = origin == null ? "" : origin;
    }


    /**
     * Returns the destination location of the trip.
     *
     * @return
     *      The destination location of the trip.
     */
    public String getDestination() {
        return mDestination;
    }


    /**
     * Set the destination location of the trip.
     *
     * @param destination
     *      The destination location of the trip.
     */
    public void setDestination(final String destination) {
        if (destination != null && !destination.equals(mDestination)) {
            this.mSearchInvalidated = true;
        }
        this.mDestination = destination == null ? "" : destination;
    }


    /**
     * Returns the results of the current search.
     *
     * @return
     *      The results of the current search.
     */
    public List<String> getSearchResults() {
        final List<String> searchResults = new ArrayList<String>();
        for (final RouteEntry entry : mRoutes) {
            searchResults.add(entry.description);
        }
        return searchResults;
    }

    /**
     * Indicates that the search has been invalidated.
     *
     * @return
     *      Whether or not the search has been invalidated or not.
     */
    public boolean isSearchInvalidated() {
        return mSearchInvalidated;
    }

}
