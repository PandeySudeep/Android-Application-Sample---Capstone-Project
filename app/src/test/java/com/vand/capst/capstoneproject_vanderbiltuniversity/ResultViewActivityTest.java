package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ComponentName;
//import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
//import org.robolectric.shadows.ShadowApplication;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.robolectric.Shadows;


@RunWith(RobolectricTestRunner.class)
public class ResultViewActivityTest {

    @Before
    public void setUp() throws Exception{
        WebService.LocalBinder stubBinder = mock(WebService.LocalBinder.class);
        when(stubBinder.getService()).thenReturn(mock(WebService.class));
        Shadows.shadowOf(RuntimeEnvironment.application).setComponentNameAndServiceForBindService(new ComponentName("com.vand.capst.capstoneproject_vanderbiltuniversity","WebService"), stubBinder);
    }

    @Test
    public void activityStateWhenMainActivityLaunches() {

        //mockBoundLocalService();
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

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
}