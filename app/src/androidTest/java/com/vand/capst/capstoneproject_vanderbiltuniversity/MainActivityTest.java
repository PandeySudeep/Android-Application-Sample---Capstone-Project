package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    public void checkFindButtonClickWorksCorrectly() throws Exception{
        mActivityRule.getActivity().findViewById(R.id.button).performClick();
        //assertTrue(mActivityRule.getActivity().findViewById(R.id.button2).isEnabled());
    }

}
