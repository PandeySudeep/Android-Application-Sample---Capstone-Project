package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class ResultView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);//preExecute()
        //update the button text as 'processing...' and disable the button
        //AsyncTask to retrieve cursor from database. doInBackground()[AsyncTask]

        //postExecute() [AsyncTask]

        Webresponse[] param=null;//placeholder to be replaced with array containing all webresponse objects
        CapstoneAdapter adapter = new CapstoneAdapter(param);

        recyclerView.setAdapter(adapter);
        //return recyclerView;

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }
}
