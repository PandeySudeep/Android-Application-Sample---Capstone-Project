package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    BroadcastReceiver mReceiver;

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


        activity=Robolectric.buildActivity(MainActivity.class).create().resume().visible().get();


        boolean buttonEnabled = activity.findViewById(R.id.button).isEnabled();
        //String buttonText = activity.findViewById(R.id.button).getText().toString();
        IntentFilter intentFilter = new IntentFilter(
                "capstone.project.action.PERSIST_COMPLETE");

        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                Button mybutton = activity.findViewById(R.id.button2);
                mybutton.setEnabled(true);

            }
        };
        //registering broadcast receiver
        activity.registerReceiver(this.mReceiver, intentFilter);
        assertTrue(mReceiver!=null);
        activity.sendBroadcast(new Intent("capstone.project.action.PERSIST_COMPLETE"));
        assertTrue(activity.findViewById(R.id.button2).isEnabled());
        //assertFalse(activity.findViewById(R.id.button).isEnabled());


    }

    //@Test
    //public void onStartStateTest() throws Exception{
        //activity=Robolectric.buildActivity(MainActivity.class).start().get();

        //assertTrue(activity!=null);
    //}

   /* @Test
    public void button_Find_PerformClickWorks() throws Exception{

        activity=Robolectric.buildActivity(MainActivity.class).create().resume().visible().get();
        activity.findViewById(R.id.button).performClick();
        assertTrue(activity.findViewById(R.id.button).isEnabled());
        //assertTrue(activity.findViewById(R.id.button2).isEnabled());

    }*/

}
