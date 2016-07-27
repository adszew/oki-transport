package au.com.adszew.okitransport.view.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import au.com.adszew.okitransport.bus.EventBus;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventBus.class)
public class RouteSearchViewModelTest {

    private RouteSearchViewModel viewModel;

    @Before
    public void initialiseInstance() {
        PowerMockito.mockStatic(EventBus.class);

        EventBus bus = mock(EventBus.class);

        PowerMockito.when(EventBus.getInstance())
                .thenReturn(bus);

        // NOTE: Ideally we should be mocking the creation of the data source as well.

        viewModel = new RouteSearchViewModel();
    }

    @Test
    public void testSetGetOffset() throws Exception {
        assertEquals(0, viewModel.getOffset());

        viewModel.setSelected(1);

        assertEquals(0, viewModel.getOffset());
    }

    @Test
    public void testGetSuggestions() throws Exception {


        final List<String> suggestions = viewModel.getSuggestions("Ken", 5);
        assertEquals(1, suggestions.size());
        assertEquals("KENCHO KITAGUCHI", suggestions.get(0));
    }

    @Test
    public void testGetSetOrigin() throws Exception {

        assertEquals("", viewModel.getOrigin());

        viewModel.setOrigin("Kencho Mae");

        assertEquals("Kencho Mae", viewModel.getOrigin());

        viewModel.setOrigin(null);

        assertEquals("", viewModel.getOrigin());

        viewModel.setOrigin("Other");

        assertEquals("Other", viewModel.getOrigin());
    }

    @Test
    public void testGetSetDestination() throws Exception {

        assertEquals("", viewModel.getDestination());

        viewModel.setDestination("Kencho Mae");

        assertEquals("Kencho Mae", viewModel.getDestination());

        viewModel.setDestination(null);

        assertEquals("", viewModel.getDestination());

        viewModel.setDestination("Other");

        assertEquals("Other", viewModel.getDestination());

    }

    @Test
    public void testGetSearchResults() throws Exception {

        viewModel.setOffset(0);
        viewModel.setOrigin("Kencho Mae");
        viewModel.setDestination("Isa");
        viewModel.performSearch();

        final List<String> searchResults = viewModel.getSearchResults();
        assertEquals(10, searchResults.size());
        assertEquals("23 - 琉球バス", searchResults.get(0));

        viewModel.setSelected(0);
    }

    @Test
    public void testIsSearchInvalidated() throws Exception {

        assertTrue(viewModel.isSearchInvalidated());
        viewModel.setDestination("Kencho Mae");

        viewModel.setOffset(0);
        viewModel.setOrigin("Kencho Mae");
        viewModel.setDestination("Isa");
        viewModel.performSearch();

        assertFalse(viewModel.isSearchInvalidated());

        viewModel.setDestination("New");

        assertTrue(viewModel.isSearchInvalidated());

    }
}