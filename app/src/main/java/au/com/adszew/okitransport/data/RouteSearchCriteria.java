package au.com.adszew.okitransport.data;

/**
 * Represents a query that will be used to retrieve a collection of routes that match
 * the specified criteria.
 */
public class RouteSearchCriteria {

    private int    offset;
    private int    limit;
    private String origin;
    private String destination;
    private int    radius;

    /**
     * Returns the offset from which results should be retrieved.
     *
     * @return
     *     The offset from which results should be retrieved.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the offset from which results should be retrieved.
     *
     * @param offset
     *      The offset from which results should be retrieved.
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the maximum number of items that will be retrieved.
     *
     * @return
     *      The maximum number of items that will be retrieved.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the maximum number of items that will be retrieved.
     *
     * @param limit
     *      The maximum number of items that will be retrieved.
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Returns the origin of the route.
     *
     * @return
     *      The origin of the route.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the route.
     *
     * @param origin
     *      The origin of the route.
     */
    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    /**
     * Returns the destination of the route.
     *
     * @return
     *      The destination of the route.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the route.
     *
     * @param destination
     *      The destination of the route.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns the radius the user is willing to travel.
     *
     * @return
     *      The radius the user is willing to travel.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius the user is willing to travel.
     *
     * @param radius
     *      The radius the user is willing to travel.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
