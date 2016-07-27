package au.com.adszew.okitransport.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A route is an ordered collection of stops, with each stop associated with
 * a departure time and any additional information related to overall route, such
 * as wheelchair accessibility.
 */
public class Route {

    private final String            id;
    private String                  routeName;
    private WheelchairAccessibility accessibility;
    private List<Stop>              stops;
    private String                  operator;
    private BigDecimal              cost;

    /**
     * Constructs a new Route which represents a collection of stops as well
     * as the overall cost of the journey (based on the cost of each stop).
     *
     * @param routeName
     *      The name that represents the collection of stops in the route.
     * @param operator
     *      The company that provides the transportation for the route.
     */
    public Route(final String id, final String routeName, final String operator) {
        this.id            = id;
        this.routeName     = routeName;
        this.operator      = operator;
        this.accessibility = WheelchairAccessibility.NOT_ACCESSIBLE;
        this.stops         = new ArrayList<Stop>();
        this.cost          = new BigDecimal(0);
    }

    /**
     * The name of the operator who provides the transportation for the route.
     *
     * @return
     *      The name of the operator who provides the transportation for the route.
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the name of the operator who provides the transportation for the route.
     *
     * @param operator
     *      The name of the operator who provides the transportation for the route.
     */
    public void setOperator(final String operator) {
        this.operator = operator;
    }

    /**
     * The name that represents the collection of stops in the route.
     *
     * @return
     *      The name that represents the collection of stops in the route.
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * Sets the name that represents the collection of stops in the route.
     *
     * @param routeName
     *      The name that represents the collection of stops in the route.
     */
    public void setRouteName(final String routeName) {
        this.routeName = routeName;
    }

    /**
     * Returns the level of wheelchair accessibility available on the route.
     *
     * @return
     *      The level of wheelchair accessibility available on the route.
     */
    public WheelchairAccessibility getAccessibility() {
        return accessibility;
    }

    /**
     * Sets the level of wheelchair accessibility available on the route.
     *
     * @param accessibility
     *      The level of wheelchair accessibility available on the route.
     */
    public void setAccessibility(final WheelchairAccessibility accessibility) {
        this.accessibility = accessibility;
    }

    /**
     * Adds a stop to the route.
     *
     * @param stop
     *      The stop to add to the route.
     */
    public void addStop(final Stop stop) {
        this.stops.add(stop);
    }

    /**
     * Returns an iterator to the collection of stops that are part of this route.
     *
     * @return
     *      Returns an iterator to the collection of stops that are part of this route.
     */
    public Iterator<Stop> getStopIterator() {
        return this.stops.iterator();
    }

    /**
     * Sets the total cost of the route.
     *
     * @param cost
     *      The total cost of the route.
     */
    public void setCost(final BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * Returns the cost of the route.
     *
     * @return
     *      The cost of the route.
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Returns the identifier of the route.
     *
     * @return
     *      The identifier of the route.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a String representation of the route.
     *
     * @return
     *      A String representation of the route.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(routeName);
        builder.append(" (").append(operator).append(")");
        return builder.toString();
    }
}
