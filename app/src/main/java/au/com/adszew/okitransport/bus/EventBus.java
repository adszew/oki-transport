package au.com.adszew.okitransport.bus;

/**
 * Abstracts the implementation of an Event Bus that will be used to communicate between components
 * in an decoupled way.
 */
public class EventBus {

    private org.greenrobot.eventbus.EventBus bus;

    private static EventBus instance;

    private EventBus() {
        bus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    /**
     * Creates a new Event Bus instance.
     *
     * @return
     *      The Event Bus singleton.
     */
    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    /**
     * Registers the object to the event bus so it that will receive events after they have been
     * sent by another component.
     *
     * @param object
     *      The object to register with the event bus.
     */
    public void register(final Object object) {
        bus.register(object);
    }

    /**
     * Unregisters the object from the event bus. Unregistered objects will no longer receive events.
     *
     * @param object
     *      The object to deregister.
     */
    public void unregister(final Object object) {
        bus.unregister(object);
    }

    /**
     * Posts the event to subscribers.
     *
     * @param event
     *      The event to send to a subscriber.
     */
    public void post(final Object event) {
        bus.post(event);
    }
}
