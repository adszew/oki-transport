package au.com.adszew.okitransport.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RouteTest {

    private Route underTest;

    @Before
    public void setup() {
        underTest = new Route("X", "Y", "Z");
    }

    @Test
    public void testGetSetOperator() throws Exception {
        assertEquals("Z", underTest.getOperator());

        underTest.setOperator("A");

        assertEquals("A", underTest.getOperator());
    }

    @Test
    public void testGetSetRouteName() throws Exception {

        assertEquals("Y", underTest.getRouteName());

        underTest.setRouteName("B");

        assertEquals("B", underTest.getRouteName());

    }

    @Test
    public void testGetSetAccessibility() throws Exception {

        assertEquals(WheelchairAccessibility.NOT_ACCESSIBLE, underTest.getAccessibility());

        underTest.setAccessibility(WheelchairAccessibility.ACCESSIBLE);

        assertEquals(WheelchairAccessibility.ACCESSIBLE, underTest.getAccessibility());

    }

    @Test
    public void testAddStop() throws Exception {

        assertFalse(underTest.getStopIterator().hasNext());

        underTest.addStop(new Stop("A", "B"));

        assertTrue(underTest.getStopIterator().hasNext());

    }

    @Test
    public void testGetSetCost() throws Exception {

        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, underTest.getCost());

        BigDecimal updated = new BigDecimal(1);
        underTest.setCost(updated);

        assertEquals(updated, underTest.getCost());
    }

    @Test
    public void testGetSetId() throws Exception {
        assertEquals("X", underTest.getId());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Y (Z)", underTest.toString());
    }
}