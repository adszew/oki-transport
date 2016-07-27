package au.com.adszew.okitransport.bus;

import android.support.test.runner.AndroidJUnit4;
import org.greenrobot.eventbus.Subscribe;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(AndroidJUnit4.class)
public class EventBusTest {

    private static class DummyEvent {
        private final String message;

        DummyEvent(final String message) {
            this.message = message;
        }
    }

    private static class DummySubscriber {

        public DummyEvent event;

        @Subscribe
        void doSomething(final DummyEvent event) {
            this.event = event;
        }
    }

    @Test
    public void testSubscribe() {

        final DummySubscriber d = new DummySubscriber();
        EventBus.getInstance().register(d);

        EventBus.getInstance().post(new DummyEvent("X"));

        assertEquals("X", d.event.message);

        EventBus.getInstance().unregister(d);
    }

    @Test
    public void testUnsubscribe() {
        final DummySubscriber d = new DummySubscriber();

        EventBus.getInstance().register(d);
        EventBus.getInstance().unregister(d);

        EventBus.getInstance().post(new DummyEvent("X"));

        assertNull(d.event);
    }
}