package au.com.adszew.okitransport.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StopTest {

    private static final double DELTA = 1e-15;

    private Stop underTest;

    @Before
    public void setup() {
        underTest = new Stop("A", "B");
    }

    @Test
    public void testGetLocalisedName() throws Exception {
        assertEquals("A", underTest.getLocalisedName());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("B", underTest.getName());
    }

    @Test
    public void testGetSetLongitude() throws Exception {
        assertEquals(0.0, underTest.getLongitude(), DELTA);

        underTest.setLongitude(1.0);

        assertEquals(1.0, underTest.getLongitude(), DELTA);
    }

    @Test
    public void testGetSetLatitude() throws Exception {
        assertEquals(0.0, underTest.getLatitude(), DELTA);

        underTest.setLatitude(1.0);

        assertEquals(1.0, underTest.getLatitude(), DELTA);
    }
}