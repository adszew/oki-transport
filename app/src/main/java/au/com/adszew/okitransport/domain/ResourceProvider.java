package au.com.adszew.okitransport.domain;

import au.com.adszew.okitransport.data.DummyDataSource;
import au.com.adszew.okitransport.data.RouteDataSource;

/**
 * Provides a mechanism for the Route Data Sources and other objects to be created when needed.
 * Centralising the creation of Data Sources makes it simpler to change the implementation at
 * another point in time.
 */
public class ResourceProvider {

    private static ResourceProvider instance = null;

    /**
     * Returns an instance to the ResourceProvider.
     *
     * @return
     *      An instance to the ResourceProvider.
     */
    public static ResourceProvider getInstance() {
        if (instance == null) {
            instance = new ResourceProvider();
        }
        return instance;
    }

    /**
     * Creates a new RouteDataSource.
     *
     * @return
     *      The created RouteDataSource.
     */
    public RouteDataSource createRouteDataSource() {
        return new DummyDataSource();
    }
}
