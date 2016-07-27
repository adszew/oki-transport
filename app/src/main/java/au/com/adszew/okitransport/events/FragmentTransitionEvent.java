package au.com.adszew.okitransport.events;

/**
 * Represents a event that will trigger the transition from one screen to another.
 */
public class FragmentTransitionEvent {

    public enum TransitionType {
        /**
         * Transition to the Route Summary screen.
         */
        ROUTE_SUMMARY;
    }

    private final TransitionType type;

    /**
     * Creates a new transition event with the specified event type.
     *
     * @param type
     *      The transition event type.
     */
    public FragmentTransitionEvent(final TransitionType type) {
        this.type = type;
    }

    /**
     * Returns the type of transition that will be performed.
     *
     * @return
     *      The type of transition that will be performed.
     */
    public TransitionType getType() {
        return type;
    }
}
