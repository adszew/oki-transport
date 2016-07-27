package au.com.adszew.okitransport.model;

/**
 * Indicates whether or not a route is wheelchair accessible or not.
 */
public enum WheelchairAccessibility {
    /**
     * The route is fully accessible.
     */
    ACCESSIBLE,
    /**
     * The route is not accessible at all.
     */
    NOT_ACCESSIBLE,
    /**
     * The route is partially accessible.
     */
    PARTIALLY_ACCESSIBLE;
}
