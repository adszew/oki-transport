package au.com.adszew.okitransport.model;

/**
 * Represents a public transport stop; a single location within a route that
 * is travelled along.
 */
public class Stop {

    /**
     * The name in the user's own language.
     */
    private final String   localisedName;
    /**
     * The name of the stop, without localisation.
     */
    private final String   name;
    /**
     * Represents the longitude of where the Stop is located.
     */
    private double         longitude;
    /**
     * Represents the latitude of where the Stop is located.
     */
    private double         latitude;

    /**
     * Creates a new representation of a stop. A stop could be a bus stop, a monorail station,
     * a train stop, or another 'stop' within a public transportation route.
     *
     * @param localisedName
     *      The localised name of the location. This will change depending on the user's locale.
     * @param name
     *      The name of the stop; this will not change based on the user's locale.
     */
    public Stop(final String localisedName, final String name) {
        this.name          = name;
        this.localisedName = localisedName;
    }

    /**
     * The localised name of the location. This will change depending on the user's locale.
     *
     * @return
     *      The localised name of the location.
     */
    public String getLocalisedName() {
        return localisedName;
    }

    /**
     * The name of the stop; this will not change based on the user's locale.
     *
     * @return
     *      The name of the stop; this will not change based on the user's locale.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the longitude portion of the location.
     *
     * @return
     *      The longitude portion of the location.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude portion of the location.
     *
     * @param longitude
     *      The longitude portion of the location.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the latitude portion of the location.
     *
     * @return
     *      The latitude portion of the location.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude portion of the location.
     *
     * @param latitude
     *      The latitiude portion of the location.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
