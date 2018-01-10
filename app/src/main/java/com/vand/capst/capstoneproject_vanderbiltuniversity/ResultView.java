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

        //get Webresponse[] from intent.
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);//preExecute()

        Webresponse[] param=null;//placeholder
        CapstoneAdapter adapter = new CapstoneAdapter(param);

        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }
}
