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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.apache.tools.ant.dispatch.DispatchUtils.execute;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Sudeep.Pandey on 1/22/2018.
 */

@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class MainActivityTest {

    //@Mock
    //WebService ws;

    private Activity activity;
    BroadcastReceiver mReceiver;
    //WebService ws;

    @Before
    public void setUp() throws Exception{

      //  activity= Robolectric.buildActivity(MainActivity.class).create().get();
        ///ws = new WebService();
    }
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

    @Test
    public void onStartStateTest() throws Exception{
       mockBoundLocalService();
       activity=Robolectric.buildActivity(MainActivity.class).start().get();
        //mockBoundLocalService();
        assertTrue(activity!=null);
    }

    @Test
    public void button_Find_PerformClickWorks() throws Exception{

        mockBoundLocalService();
        //Spinner mySpinner=(Spinner) activity.findViewById(R.id.spinner);
        //assertTrue(mySpinner.getCount()!=0);

        //when(ws.execute(anyS);)
        activity=Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();

        Spinner mySpinner=(Spinner) activity.findViewById(R.id.spinner);
        assertTrue(mySpinner.getCount()!=0);
        //activity.findViewById(R.id.button).performClick();
        assertTrue(activity.findViewById(R.id.button).isEnabled());
        assertFalse(activity.findViewById(R.id.button2).isEnabled());

        assertTrue(activity.findViewById(R.id.button).isClickable());
        //when(mock(WebService.class).execute(anyString(),anyString())).thenReturn(new Void()));
        //doNothing().when(mock(WebService.class)).execute(anyString(), anyString());
        Mockito.doCallRealMethod().when(mock(WebService.class)).execute(anyString(), anyString());
        //when(mock(WebService.class)).execute(anyString(), anyString()).then(activity.sendBroadcast(new Intent("check")));
        activity.findViewById(R.id.button).performClick();
        assertFalse(activity.findViewById(R.id.button2).isEnabled());

    }

   @Test
   public void onPauseLifecycleMethodUnregistersReceiver() throws Exception{

       activity=Robolectric.buildActivity(MainActivity.class).create().resume().visible().pause().get();
       activity.sendBroadcast(new Intent("capstone.project.action.PERSIST_COMPLETE"));
       assertFalse(activity.findViewById(R.id.button2).isEnabled());
   }

    @Test
    public void onStopMethodRetainsActivity() throws Exception{

        mockBoundLocalService();
        activity=Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().pause().stop().get();
       // activity.sendBroadcast(new Intent("capstone.project.action.PERSIST_COMPLETE"));
        //assertFalse(activity.findViewById(R.id.button2).isEnabled());
        //verify(mock(WebService.class), atLeast(1)).onUnbind(mock(Intent.class));

        //verify(mock(WebService.class)).onUnbind(mock(Intent.class));
        //mock(activity.m).execute(anyString(),anyString());
        assertTrue(activity!=null);

    }

   private void mockBoundLocalService(){
       WebService.LocalBinder stubBinder = mock(WebService.LocalBinder.class);
       //WebService.LocalBinder stubBinder = mock();
       //when(stubBinder.getService()).thenReturn(mock(WebService.class));
       when(stubBinder.getService()).thenReturn(mock(WebService.class));
      // when(mock(WebService.class).b)
       //WebService spy=Mockito.spy(ws);
       //Mockito.doNothing().when(spy).execute(anyString(),anyString());

       //when(ws.execute(anyString(),anyString())).thenReturn(Void value);
       //when(stubBinder.getService()).thenReturn(ws);
       shadowOf(RuntimeEnvironment.application).setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);
      //new ShadowApplication().setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);
       //.setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);
   }

}
