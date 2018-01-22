package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import org.robolectric.Shadows;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ResultViewActivityTest {

   // @Mock
    //WebService ws;

   // @Mock
   // View.OnClickListener listener;

    MainActivity activity;

    @Before
    public void setUp() throws Exception{
        WebService.LocalBinder stubBinder = mock(WebService.LocalBinder.class);
        when(stubBinder.getService()).thenReturn(mock(WebService.class));
       // when(stubBinder.getService()).thenReturn((ws));
        Shadows.shadowOf(RuntimeEnvironment.application).setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);

        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void activityStateWhenMainActivityLaunches() {

        //mockBoundLocalService();
        //MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        assertTrue(activity.findViewById(R.id.button).isEnabled());

        assertFalse(activity.findViewById(R.id.button2).isEnabled());

        //activity.findViewById(R.id.button).performClick();
        //activity.findViewById(R.id.button2).performClick();

        //Intent expectedIntent = new Intent(activity, ResultView.class);
        //Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        //assertEquals(expectedIntent.getComponent(), actual.getComponent());

    }
    //private void mockBoundLocalService(){
      //  WebService.LocalBinder stubBinder = mock(WebService.LocalBinder.class);
        //when(stubBinder.getService()).thenReturn(mock(WebService.class));
        //Shadows.shadowOf(RuntimeEnvironment.application).setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);
    //}


   /* @Test
   public void clickingFindMeShouldChangeMainActivityState(){

       // activity = Robolectric.setupActivity(MainActivity.class);
        //activity.mBound=true;
        //when(listener.onClick(mock(View.class)).doAnswer(ws.execute(anyString(),anyString())));
        //ws.execute(anyString(),anyString()).when(listener.onClick(mock(View.class)));
        //Mockito.doAnswer(ws.execute(anyString(),anyString())).when(listener.onClick(mock(View.class)));
        //activity.findViewById(R.id.button).setOnClickListener(listener);
        activity.findViewById(R.id.button).performClick();

        //WebService.onCreate();


        assertFalse(activity.findViewById(R.id.button).isEnabled());
        //assertEquals((Button)activity.findViewById(R.id.button).getAccessibilityClassName(),"thank you..");

        //activity.setLatitude();
        //activity.setLongitude();
        //Log.d(TAG, "web service called: latitude: "+latitude+"longitude: "+longitude+".");
        //String requestUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+activity.latitude+","+activity.longitude+"&radius=1000&type="+activity.getInterest()+"&key=AIzaSyDo7-hsZ6-c5YaxfB8R906UFjkOE20K3yA";
        //button.setEnabled(false);
        //button.setText("thank you..");
        //ws.execute(anyString(),anyString());
        assertFalse(activity.findViewById(R.id.button2).isEnabled());

    }*/

    @Test
    public void broadcastReceiverWhenCalledEnablesViewButton(){

        Application application = RuntimeEnvironment.application;
        //Intent expectedService = new Intent(application, SampleIntentService.class);
        //IntentFilter intentFilter = new IntentFilter(
                //"capstone.project.action.PERSIST_COMPLETE");
        activity.mReceiver.onReceive(application,new Intent().setAction("capstone.project.action.PERSIST_COMPLETE"));
                //= new BroadcastReceiver() {
            //@Override
            //public void onReceive(Context context, Intent intent) {

            //}
        assertTrue(activity.findViewById(R.id.button2).isEnabled());

        }

       // AlarmManagerReceiver alarmManagerReceiver = new AlarmManagerReceiver();
        //alarmManagerReceiver.onReceive(application, new Intent().setAction("capstone.project.action.PERSIST_COMPLETE"));

        //Intent serviceIntent = shadowOf(application).getNextStartedService();
       // assertNotNull("Service started ",serviceIntent);
        //assertEquals("Started service class ", serviceIntent.getComponent(),
                //expectedService.getComponent());

}