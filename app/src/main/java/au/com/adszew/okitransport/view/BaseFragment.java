package au.com.adszew.okitransport.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Observer;

/**
 * Base class for all fragments. Provides methods for simplifying the creation of new Views.
 */
public abstract class BaseFragment extends Fragment implements Observer {

    /**
     * Extracts data from a bundle and casts it to the specified class.
     *
     * @param key
     *      The key used to identify the data within the bundle.
     * @param clazz
     *      The class to cast the data to (from an Object).
     * @param bundle
     *      The bundle to retrieve the data from.
     * @param <T>
     *      The class that will be casted to.
     * @return
     */
    public <T> T getFromBundle(final String key, Class<? extends T> clazz, Bundle bundle) {
        return clazz.cast(bundle.getSerializable(key));
    }

    /**
     * Configures the keyboard so that it will be hidden when the user selects an area
     * that is not an editable area.
     *
     * @param view
     *      The view from which to recursively configure the keyboard for.
     *
     * Source: from http://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext
     */
    public void configureKeyboard(final View view) {
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); ++i) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                configureKeyboard(innerView);
            }
        }

    }

    /**
     * Hides the soft keyboard.
     */
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (getActivity().getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }
}


