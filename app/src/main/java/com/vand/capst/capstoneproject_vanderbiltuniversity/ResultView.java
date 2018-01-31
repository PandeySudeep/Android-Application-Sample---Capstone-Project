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

        String[] myResponses = getIntent().getStringArrayExtra("responseArray");
        Webresponse[] responseObjects = new Webresponse[myResponses.length];
        for(int i=0;i<myResponses.length;i++){
            responseObjects[i]=(new Webresponse(myResponses[i]));
        }
        //get Webresponse[] from intent.
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        CapstoneAdapter adapter = new CapstoneAdapter(responseObjects);

        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }
}
