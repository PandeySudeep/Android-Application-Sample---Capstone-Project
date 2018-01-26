package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.RoboLayoutInflater;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.widget.TextView;


/**
 * Created by Sudeep.Pandey on 1/23/2018.
 */
@RunWith(RobolectricTestRunner.class)
//@Config(constants=BuildConfig.class)
public class CapstoneAdapterTest {

    CapstoneAdapter adapter;
    Webresponse[] responses = new Webresponse[]{new Webresponse("one"),new Webresponse("two")};
    CardView cardView;
    RecyclerView rView;

    @Before
    public void setUp(){
        adapter = new CapstoneAdapter(responses);
        RoboLayoutInflater inflater = new RoboLayoutInflater(Robolectric.buildActivity(ResultView.class).get());
        cardView =  (CardView)inflater.from(Robolectric.buildActivity(ResultView.class).get()).inflate(R.layout.card_v,null);
        rView = (RecyclerView)inflater.from(Robolectric.buildActivity(ResultView.class).get()).inflate(R.layout.activity_result_view,null).findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,1);
        rView.setLayoutManager(manager);
    }

    @Test
    public void checkIfgetItemCountReturnsCorrectNumber() throws Exception{
        int itemCount = adapter.getItemCount();
        assertEquals(itemCount,2);
    }

    @Test
    public void onCreateViewHolderShouldCreateCorrectViewHolder() throws Exception{

        CapstoneAdapter.ViewHolder holder = adapter.onCreateViewHolder(rView,0);
        assertNotNull(holder);
        assertTrue(holder.getClass()==(new CapstoneAdapter.ViewHolder(cardView).getClass()));
    }

    @Test
    public void checkIfOnBindViewHolderGeneratesCorrectCardView() throws Exception{

        TextView textView = (TextView)cardView.findViewById(R.id.web_response);

        adapter.onBindViewHolder(new CapstoneAdapter.ViewHolder(cardView),1);
        assertEquals(textView.getText(),"two");

        adapter.onBindViewHolder(new CapstoneAdapter.ViewHolder(cardView),0);
        assertEquals(textView.getText(),"one");

    }
}
