package au.com.adszew.okitransport.domain;

import java.util.Collections;
import java.util.List;

import au.com.adszew.okitransport.data.RouteDataSource;
import au.com.adszew.okitransport.data.RouteSearchCriteria;
import au.com.adszew.okitransport.data.StopSearchCriteria;
import au.com.adszew.okitransport.model.Route;
import au.com.adszew.okitransport.model.Stop;

/**
 * Queries a data source for routes that match the conditions specified by the user.
 *
 * Although the data access layer performs similar functions, the RouteQueryController
 * encapsulates the processing that needs to be performed independently of data access. Data sources
 * should not be used directly.
 */
public class RouteQueryController {

    private RouteDataSource dataSource;

    /**
     * Creates a new controller that will retrieve data from the specified data source.
     *
     * @param dataSource
     *      Th datasource to retrieve the details from.
     */
    RouteQueryController(final RouteDataSource dataSource) {
        this.dataSource = dataSource;
        this.dataSource.initialise();
    }

    /**
     * Creates anew controller that will retrieve data from the application's default Data Source.
     */
    public RouteQueryController() {
        this(ResourceProvider.getInstance().createRouteDataSource());
    }

    /**
     * Searches the known routes for the specified starting location and destination.
     * The destination location must exist after the starting location.
     *
     * @param start
     *         The anticipated start of the user's journey.
     * @param end
     *         The anticipated end of the user's journey.
     * @param offset
     *         The offset from which to retrieve results from.
     * @param limit
     *         The maximum number of items to retrieve.
     * @return
     *     A list of routes matching the specified criteria. If no matching routes
     *     were found then an empty list is returned.
     */
    public List<Route> searchForRoutes(final String start, final String end, int offset, int limit) {
        final RouteSearchCriteria criteria = new RouteSearchCriteria();
        criteria.setOffset(offset);
        criteria.setLimit(limit);
        criteria.setDestination(end);
        criteria.setOrigin(start);
        final List<Route> routes = dataSource.searchRoutes(criteria);
        return Collections.unmodifiableList(routes);
    }


    /**
     * Retrieves the specified route by its identifier. If a matching route could not
     * be found, then <code>null</code> is returned.
     *
     * @param routeId
     *      The identifier of the route to search for.
     * @return
     *      The route, if it could be found, otherwise returns <code>null</code>.
     */
    public Route retrieveRoute(final String routeId) {
        return dataSource.retrieveRouteById(routeId);
    }

    /**
     * Searches the known stops for a list of stop whose name partially or fully matches
     * the specified <code>partialName</code>.
     *
     * @param partialName
     *      The name of the stop to search for.
     * @param limit
     *      The maximum number of items to retrieve.
     * @return
     *      A list of stops that match the partial name.
     */
    public List<Stop> searchForStops(final String partialName, int limit) {
        final StopSearchCriteria criteria = new StopSearchCriteria();
        criteria.setStopName(partialName);
        criteria.setLimit(limit);
        return Collections.unmodifiableList(dataSource.searchStops(criteria));
    }
}
