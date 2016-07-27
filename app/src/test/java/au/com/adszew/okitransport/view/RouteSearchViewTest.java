package au.com.adszew.okitransport.view;

import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import au.com.adszew.okitransport.BuildConfig;
import au.com.adszew.okitransport.view.model.RouteSearchViewModel;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RouteSearchViewTest {

    private RouteSearchView fragment;

    private RouteSearchViewModel viewModel;

    @Before
    public void configureMock() {
        viewModel = mock(RouteSearchViewModel.class);

        final List<String> results = new ArrayList<String>();
        results.add("1");
        results.add("2");
        results.add("3");

        when(viewModel.getSearchResults()).thenReturn(results);

        fragment = RouteSearchView.newInstance(viewModel);

        FragmentCompV4TestUtil.startFragment(fragment);
    }

    @Test
    public void testSetOrigin() {

        fragment.mSearchOrigin.setText("Kencho Mae");

        verify(viewModel, times(1)).setOrigin(eq("Kencho Mae"));
    }

    @Test
    public void testSetDestination() {

        fragment.mSearchDestination.setText("Isa");

        verify(viewModel, times(1)).setDestination(eq("Isa"));
    }

    @Test
    public void testPerformSearch() {

        fragment.mPerformSearch.performClick();

        verify(viewModel, times(1)).performSearch();
    }

    private void performListItemClick(final ListView view, int position) {
        view.performItemClick(
                view.getAdapter().getView(position, null, null),
                position,
                view.getAdapter().getItemId(position));
    }

    @Test
    public void testSelectItem() {

        performListItemClick(fragment.mSearchResults, 0);

        verify(viewModel, times(1)).setSelected(0);
    }

    // TODO: Handle scroll

}