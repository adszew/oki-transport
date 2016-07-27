package au.com.adszew.okitransport.view.model;

import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import au.com.adszew.okitransport.bus.EventBus;
import au.com.adszew.okitransport.domain.RouteQueryController;
import au.com.adszew.okitransport.events.RouteSelectedEvent;
import au.com.adszew.okitransport.model.Route;
import au.com.adszew.okitransport.model.Stop;

/**
 * Represents the data that will be displayed on the Route Detail screen.
 */
public class RouteDetailViewModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String       routeName;
    private String       routeAccessibility;
    private String       cost;
    private List<String> stopList;

    public RouteDetailViewModel() {
        this.stopList = new ArrayList<String>();
        EventBus.getInstance().register(this);
    }

    /**
     * Returns the accessibility (wheelchair access, etc.) of the route.
     *
     * @return
     *     The accessibility (wheelchair access, etc.) of the route.
     */
    public String getRouteAccessibility() {
        return routeAccessibility;
    }

    /**
     * Sets the route accessibility (wheelchair access, etc.) of the route.
     *
     * @param routeAccessibility
     *       The accessibility (wheelchair access, etc.) of the route.
     */
    public void setRouteAccessibility(final String routeAccessibility) {
        this.routeAccessibility = routeAccessibility;
    }

    /**
     * Returns the name of the route.
     *
     * @return
     *      The name of the route.
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * Sets the name of the route.
     *
     * @param routeName
     *      The name of the route.
     */
    public void setRouteName(final String routeName) {
        this.routeName = routeName;
    }

    /**
     * Sets the cost of the route.
     *
     * @param cost
     *      The cost of the route.
     */
    public void setCost(final String cost) {
        this.cost = cost;
    }

    /**
     * Returns the cost of the route.
     *
     * @return
     *    The cost of the route.
     */
    public String getCost() {
        return cost;
    }

    /**
     *
     * @return
     */
    public List<String> getStopList() {
        return Collections.unmodifiableList(stopList);
    }

    /**
     * Updates the details stored in the view model, after an event has been received.
     *
     * @param event
     *      The event to retrieve the details from.
     */
    @Subscribe
    public void updateDetails(final RouteSelectedEvent event) {

        final RouteQueryController controller = new RouteQueryController();

        final Route route = controller.retrieveRoute(event.getRouteId());
        if (route != null) {
            routeName          = route.getRouteName();
            routeAccessibility = route.getAccessibility().name();

            final NumberFormat n = NumberFormat.getCurrencyInstance(Locale.JAPAN);
            cost = n.format(route.getCost().doubleValue());

            Iterator<Stop> i = route.getStopIterator();
            while (i.hasNext()) {
                final Stop stop = i.next();
                stopList.add(stop.getName());
            }
        }
    }
}
