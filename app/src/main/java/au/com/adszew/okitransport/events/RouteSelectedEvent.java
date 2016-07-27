package au.com.adszew.okitransport.events;

/**
 * An Event used to indicate that a route has been selected.
 */
public class RouteSelectedEvent {

    private final String routeId;

    /**
     * Creates a new RouteSelectedEvent indicating that the specified route has been selected.
     *
     * @param routeId
     *      The route that has been selected.
     */
    public RouteSelectedEvent(final String routeId) {
        this.routeId = routeId;
    }

    /**
     * Returns the route that has been selected.
     *
     * @return
     *      The selected route.
     */
    public String getRouteId() {
        return routeId;
    }
}
