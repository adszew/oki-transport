package au.com.adszew.okitransport.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import au.com.adszew.okitransport.BuildConfig;
import au.com.adszew.okitransport.view.model.RouteDetailViewModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RouteDetailViewTest {

    private RouteDetailViewModel viewModel;

    @Before
    public void configureMock() {
        viewModel = mock(RouteDetailViewModel.class);

        when(viewModel.getRouteAccessibility()).thenReturn("Accessibility");
        when(viewModel.getCost()).thenReturn("$5");
        when(viewModel.getRouteName()).thenReturn("29");
    }

    @Test
    public void testView() {

        final RouteDetailView fragment = RouteDetailView.newInstance(viewModel);

        FragmentCompV4TestUtil.startFragment(fragment);

        assertEquals("$5", fragment.mRouteCostText.getText());
        assertEquals("Accessibility", fragment.mAccessibilityText.getText());
        assertEquals("29", fragment.mRouteName.getText());
    }

}