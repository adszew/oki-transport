package au.com.adszew.okitransport.view.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.adszew.okitransport.bus.EventBus;
import au.com.adszew.okitransport.events.RouteSelectedEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventBus.class)
public class RouteDetailViewModelTest {

    private RouteDetailViewModel viewModel;

    @Before
    public void initialiseInstance() {
        PowerMockito.mockStatic(EventBus.class);

        EventBus bus = mock(EventBus.class);

        PowerMockito.when(EventBus.getInstance())
            .thenReturn(bus);

        viewModel = new RouteDetailViewModel();
    }


    @Test
    public void testGetSetRouteAccessibility() throws Exception {
        assertNull(viewModel.getRouteAccessibility());

        viewModel.setRouteAccessibility("X");

        assertEquals("X", viewModel.getRouteAccessibility());
    }

    @Test
    public void testGetSetRouteName() throws Exception {

        assertNull(viewModel.getRouteName());

        viewModel.setRouteName("X");

        assertEquals("X", viewModel.getRouteName());
    }

    @Test
    public void testGetSetCost() throws Exception {

        assertNull(viewModel.getCost());

        viewModel.setCost("$0");

        assertEquals("$0", viewModel.getCost());
    }

    @Test
    public void testGetStopList() throws Exception {

        assertEquals(0, viewModel.getStopList().size());

        // Cannot modify list
    }

    @Test
    public void testUpdateDetails() throws Exception {

        final RouteSelectedEvent selected = new RouteSelectedEvent("1");

        viewModel.updateDetails(selected);

        assertEquals("￥0", viewModel.getCost()); // Note; currently hardcoded.
        assertEquals("28", viewModel.getRouteName());
        assertEquals("NOT_ACCESSIBLE", viewModel.getRouteAccessibility());
    }
}