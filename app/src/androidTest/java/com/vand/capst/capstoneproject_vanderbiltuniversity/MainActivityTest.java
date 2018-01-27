package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

//import com.android.dx.command.Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.intent.matcher.UriMatchers.hasHost;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static android.support.test.espresso.Espresso.onView;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Sudeep.Pandey on 1/27/2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //@Rule
    //public IntentsTestRule<MainActivity> intentsTestRule =
      //      new IntentsTestRule<>(MainActivity.class);

    @Test
    public void checkInitialUIState(){

        onView(withId(R.id.button)).check(matches(withText("Find")));
        onView(withId(R.id.button2)).check(matches(withText("View Result")));
        onView(withId(R.id.button)).check(matches(isEnabled()));
        onView(withId(R.id.button2)).check(matches(not(isEnabled())));

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.button)).check(matches(not(isEnabled())));
        onView(withId(R.id.button2)).check(matches(isEnabled()));

        onView(withId(R.id.button2)).perform(click());

        //intended(
                //allOf(
                //hasAction(equalTo(Intent.ACTION_VIEW)),
                //hasCategories(hasItem(equalTo(Intent.CATEGORY_BROWSABLE))),
                //hasData(hasHost(equalTo("www.google.com"))),
                //hasExtras(allOf(
                  //      hasEntry(equalTo("key1"), equalTo("value1")),
                    //    hasEntry(equalTo("key2"), equalTo("value2")))),
                //toPackage("com.vand.capst.capstoneproject_vanderbiltuniverity"));
        //intended(hasComponent(ResultView.class.getName()));

    }
}
