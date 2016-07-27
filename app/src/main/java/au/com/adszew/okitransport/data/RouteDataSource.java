package au.com.adszew.okitransport.data;

import java.util.List;

import au.com.adszew.okitransport.model.Route;
import au.com.adszew.okitransport.model.Stop;

/**
 * Provides the interface that all DataSources need to provide in order to allow uniform access
 * to Route objects, regardless of the underlying technology used to search for the objects.
 */
public interface RouteDataSource {

    /**
     * Initialises the data source so that it can be used.
     */
    void initialise();

    /**
     * Retrieves a route by the specified identifier.
     *
     * @param id
     *      The identifier of the route to retrieve.
     * @return
     *      The matching route if found, otherwise returns <code>null</code>.
     */
    Route retrieveRouteById(final String id);

    /**
     * Deletes the specified route which matches the provided id.
     *
     * @param id
     *      The identifier of the route to delete.
     */
    void deleteRouteById(final String id);

    /**
     * Updates the details of the route.
     *
     * @param route
     *      The route to update.
     */
    void updateRoute(final Route route);

    /**
     * Adds the route to the DataSource.
     *
     * @param route
     *      The route to add.
     */
    void addRoute(final Route route);

    /**
     * Searches for stops that match the specified criteria.
     *
     * @param criteria
     *      The criteria that the stop must match for it be returned.
     *
     * @return
     *      The Stops which match the criteria.
     */
    List<Stop> searchStops(final StopSearchCriteria criteria);

    /**
     * Searches for routes that match the specified criteria.
     *
     * @param criteria
     *      The criteria that the route must match for it to be returned.
     *
     * @return
     *      The Routes which match the criteria.
     */
    List<Route> searchRoutes(final RouteSearchCriteria criteria);

}
