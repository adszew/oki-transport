package au.com.adszew.okitransport.view;

import org.robolectric.Robolectric;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * Simplifies the process of testing Fragments by creating a simple activity and injecting a
 * single Fragment into it.
 */
public final class FragmentCompV4TestUtil {

    public static void startFragment(Fragment fragment) {
        buildFragmentManager(FragmentUtilActivity.class)
                .beginTransaction().add(fragment, null).commit();
    }

    public static void startFragment(Fragment fragment, Class<? extends AppCompatActivity> activityClass) {
        buildFragmentManager(activityClass)
                .beginTransaction().add(fragment, null).commit();
    }

    public static void startVisibleFragment(Fragment fragment) {
        //noinspection ResourceType
        buildFragmentManager(FragmentUtilActivity.class)
                .beginTransaction().add(1, fragment, null).commit();
    }

    public static void startVisibleFragment(Fragment fragment,
                                            Class<? extends AppCompatActivity> activityClass, int containerViewId) {
        buildFragmentManager(activityClass)
                .beginTransaction().add(containerViewId, fragment, null).commit();
    }

    private static FragmentManager buildFragmentManager(Class<? extends AppCompatActivity> activityClass) {
        AppCompatActivity activity = Robolectric.setupActivity(activityClass);
        return activity.getSupportFragmentManager();
    }

    private static class FragmentUtilActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            LinearLayout view = new LinearLayout(this);
            //noinspection ResourceType
            view.setId(1);

            setContentView(view);
        }
    }
}
