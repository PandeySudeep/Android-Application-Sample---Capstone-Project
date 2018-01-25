package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import android.support.v7.widget.StaggeredGridLayoutManager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Sudeep.Pandey on 1/25/2018.
 */
@RunWith(RobolectricTestRunner.class)
public class ResultViewTest {

    private Activity activity;

    @Test
    public void checkOnCreateLifeCycleStage() throws Exception{

        //Intent intent = new Intent()
        Intent intent = new Intent(RuntimeEnvironment.application,ResultView.class);
        intent.putExtra("responseArray",new String[]{"one","two","three","four","five"});

        activity = Robolectric.buildActivity(ResultView.class,intent).create().resume().visible().get();
        RecyclerView recyclerView = activity.findViewById(R.id.recyclerView);
        assertNotNull(recyclerView);

       // Webresponse[] responses = new Webresponse[]{new Webresponse("one"),new Webresponse("two"),new Webresponse("three"),new Webresponse("four"),new Webresponse("five")};
        //CapstoneAdapter adapter = new CapstoneAdapter(responses);

        //recyclerView.setAdapter(adapter);
        //StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(manager);

        //assertNotNull(recyclerView);

    }

}
