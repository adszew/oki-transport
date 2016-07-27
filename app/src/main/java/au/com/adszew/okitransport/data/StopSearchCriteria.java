package au.com.adszew.okitransport.data;

/**
 * Used to build queries that will retrieve a list of Stops that match a specified query.
 */
public class StopSearchCriteria {

    /**
     * The default number of items to return.
     */
    public static final int DEFAULT_SEARCH_LIMIT = 10;

    private String mStopName;
    private int    mLimit;

    /**
     * Creates a new query, that by default will return no more than 10 items.
     */
    public StopSearchCriteria() {
        mStopName = "";
        mLimit    = DEFAULT_SEARCH_LIMIT;
    }

    /**
     * Returns the stop (or partial) name to search for.
     *
     * @return
     *      The stop (or partial) name to search for.
     */
    public String getStopName() {
        return mStopName;
    }

    /**
     * Sets the stop name to search for.
     *
     * @param stopName
     *      The stop name to search for.
     */
    public void setStopName(final String stopName) {
        this.mStopName = stopName;
    }

    /**
     * Returns the maximum number of items that will be returned from query.
     *
     * @return
     *      The maximum number of items that will be returned from query.
     */
    public int getLimit() {
        return mLimit;
    }

    /**
     * Sets the maximum number of items that will be returned from query.
     *
     * @param limit
     *      The maximum number of items that will be returned from query.
     */
    public void setLimit(int limit) {
        this.mLimit = limit;
    }
}
