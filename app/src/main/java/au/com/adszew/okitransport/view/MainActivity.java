package au.com.adszew.okitransport.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.Window;

import org.greenrobot.eventbus.Subscribe;

import au.com.adszew.okitransport.R;
import au.com.adszew.okitransport.bus.EventBus;
import au.com.adszew.okitransport.events.FragmentTransitionEvent;
import au.com.adszew.okitransport.view.model.RouteDetailViewModel;
import au.com.adszew.okitransport.view.model.RouteSearchViewModel;

/**
 * The main activity of the application.
 *
 * Manages the Fragments (and transitions between them) that makeup the screens of the application.
 */
public class MainActivity extends AppCompatActivity {

    private static final String SEARCH_FRAGMENT = "MainActivity.SearchFragment";
    private static final String DETAIL_FRAGMENT = "MainActivity.DetailFragment";

    private RouteSearchView mSearchFragment;

    private RouteDetailView mDetailView;

    /**
     *  {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mSearchFragment = restoreFragment(SEARCH_FRAGMENT, RouteSearchView.class, savedInstanceState);
            mDetailView     = restoreFragment(DETAIL_FRAGMENT, RouteDetailView.class, savedInstanceState);
        }

        if (mDetailView == null) {
            mDetailView = RouteDetailView.newInstance(new RouteDetailViewModel());
        }

        if (mSearchFragment == null) {
            mSearchFragment = RouteSearchView.newInstance(new RouteSearchViewModel());
        }

        if (savedInstanceState == null) {
            setFragment(mSearchFragment, false);
        }
    }

    /**
     * Retrieves a Fragment from a Bundle.
     *
     * @param key
     *      The key that the Fragment is associated with.
     * @param clazz
     *      The class of the Fragment.
     * @param bundle
     *      The bundle to extract the Fragment from.
     * @param <T>
     *      The Fragment class.
     * @return
     *      The Fragment, if one could be found, otherwise returns <code>null</code>.
     */
    private <T> T restoreFragment(final String key, Class<? extends T> clazz, Bundle bundle) {
        return clazz.cast(getSupportFragmentManager().getFragment(bundle, key));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getInstance().unregister(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mSearchFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, SEARCH_FRAGMENT, mSearchFragment);
        }
        if (mDetailView.isAdded()) {
            getSupportFragmentManager().putFragment(outState, DETAIL_FRAGMENT, mDetailView);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getInstance().register(this);
    }

    /**
     * Handles fragment transitions that have been initiated from another view.
     * This ensures loose coupling between views, to allow them to be easily
     * tested and reused.
     *
     * @param event
     *      The event to handle to determine what type of transition will be performed.
     */
    @Subscribe
    public void handleTransition(final FragmentTransitionEvent event) {
        if (FragmentTransitionEvent.TransitionType.ROUTE_SUMMARY.equals(event.getType())) {
            setFragment(mDetailView, true);
        }
    }

    /**
     * Handles the actual replacement of the fragment within the FragmentContainer
     * and also adds the Fragment to the back stack.
     *
     * @param next
     *      The fragment to transition to.
     */
    private void setFragment(final Fragment next, boolean addToBackStack) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragment_container, next);
        if (addToBackStack) {
            t.addToBackStack(null);
        }
        t.commit();
    }

}
