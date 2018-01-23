package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sudeep.Pandey on 1/22/2018.
 */

@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private Activity activity;

    //@Before
    //public void setUp() throws Exception{

      //  activity= Robolectric.buildActivity(MainActivity.class).create().get();
    //}
    @Test
    public void onCreateLifeCyclePhaseTest() throws Exception{

        activity= Robolectric.buildActivity(MainActivity.class).create().get();
        assertNotNull(activity);

        Spinner spinner = activity.findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
               // R.array.popular_points, android.R.layout.simple_spinner_item);
        assertFalse(spinner.getAdapter().isEmpty());
        assertEquals(spinner.getCount(),8);
        assertEquals(spinner.getItemAtPosition(0),"Statue of Liberty");

        Spinner spinner2 = activity.findViewById(R.id.spinner2);

        assertFalse(spinner2.getAdapter().isEmpty());
        assertEquals(spinner2.getCount(),5);
        assertEquals(spinner2.getItemAtPosition(0),"hospital");

        assertFalse(activity.findViewById(R.id.button2).isEnabled());

    }

    @Test
    public void onResumeLifeCyclePhaseTest() throws Exception{



    }
}
