package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sudeep.Pandey on 1/22/2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {

    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    //@Rule
   // public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            //MainActivity.class);

    @Test
    public void testWithBoundService() throws Exception{

        // Create the service Intent.
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(), WebService.class);

        // Data can be passed to the service via the Intent.
        //serviceIntent.putExtra(LocalService.SEED_KEY, 42L);

        // Bind the service and grab a reference to the binder.
        IBinder binder = mServiceRule.bindService(serviceIntent);

        // Get the reference to the service, or you can call public methods on the binder directly.
        WebService service = ((WebService.LocalBinder) binder).getService();

        // Verify that the service is working correctly.
        //assertNotNull(service.execute(anyString(),anyString());, is(any(Integer.class)));
        service.execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.40,-70.32&radius=1000&type=hospital&key=AIzaSyDo7-hsZ6-c5YaxfB8R906UFjkOE20K3yA","hospital");
        //assertTrue(MainActivity.findViewById(R.id.button2).isEnabled());

        //onView(withId(R.id.button2)).check(matches(isEnabled()));
    }
}
