package au.com.adszew.okitransport.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StopSearchCriteriaTest {

    private StopSearchCriteria underTest;

    @Before
    public void setup() {
        underTest = new StopSearchCriteria();
    }

    @Test
    public void testGetSetStopName() throws Exception {

        assertEquals("", underTest.getStopName());

        underTest.setStopName("X");

        assertEquals("X", underTest.getStopName());

    }

    @Test
    public void testGetSetLimit() throws Exception {

        assertEquals(10, underTest.getLimit());

        underTest.setLimit(1);

        assertEquals(1, underTest.getLimit());

    }
}