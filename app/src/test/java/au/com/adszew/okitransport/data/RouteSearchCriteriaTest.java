package au.com.adszew.okitransport.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class RouteSearchCriteriaTest {

    private RouteSearchCriteria underTest;

    @Before
    public void setup() {
        underTest = new RouteSearchCriteria();
    }

    @Test
    public void testGetSetOffset() throws Exception {
        assertEquals(0, underTest.getOffset());

        underTest.setOffset(10);

        assertEquals(10, underTest.getOffset());
    }

    @Test
    public void testGetSetLimit() throws Exception {

        assertEquals(0, underTest.getLimit());

        underTest.setLimit(10);

        assertEquals(10, underTest.getLimit());
    }

    @Test
    public void testGetSetOrigin() throws Exception {
        assertNull(underTest.getOrigin());

        underTest.setOrigin("X");

        assertEquals("X", underTest.getOrigin());
    }

    @Test
    public void testGetSetDestination() throws Exception {

        assertNull(underTest.getDestination());

        underTest.setDestination("X");

        assertEquals("X", underTest.getDestination());

    }

    @Test
    public void testGetSetRadius() throws Exception {

        assertEquals(0, underTest.getRadius());

        underTest.setRadius(1);

        assertEquals(1, underTest.getRadius());

    }

}