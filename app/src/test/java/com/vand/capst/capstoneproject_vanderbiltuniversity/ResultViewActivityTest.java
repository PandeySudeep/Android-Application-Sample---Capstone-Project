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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    public void activityStateWhenMainActivityLaunches() throws Exception {

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


    @Test
    public void broadcastReceiverWhenCalledEnablesViewButton() throws Exception{

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



    @Test
    public void sendingBroadcastSuccessfullyCallsReceiver() throws Exception{

        Application application = RuntimeEnvironment.application;
        Intent intent = new Intent();
        intent.setAction("capstone.project.action.PERSIST_COMPLETE");
        application.sendBroadcast(intent);

        //BroadcastReceiver receiver = Mockito.spy(activity.mReceiver);

        //verify((activity.mReceiver), times(1)).onReceive(application,intent);
        //verify((Mockito.spy(activity.mReceiver)), times(1)).onReceive(application,intent);
        assertTrue(activity.findViewById(R.id.button2).isEnabled());

    }
}