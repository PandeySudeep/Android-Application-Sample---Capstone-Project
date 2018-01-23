package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.shadows.RoboLayoutInflater;
import org.robolectric.shadows.ShadowFrameLayout;
import org.robolectric.shadows.ShadowView;
import org.robolectric.shadows.ShadowViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sudeep.Pandey on 1/23/2018.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class)
public class CapstoneAdapterTest {

    CapstoneAdapter adapter;
    Webresponse[] responses = new Webresponse[]{new Webresponse("one"),new Webresponse("two")};

    //ShadowCardView cardView;
    //MyViewGroup svg;
    //Context ctx;
    //SVG svg = new SVG();
    //ViewGroup parent;
    //ShadowViewGroup shadowViewGroup = new ShadowViewGroup();


    //ShadowViewGroup SVG = Shadows.shadowOf(ViewGroup v);
    //CapstoneAdapter.ViewHolder vh;
    //ViewGroup v;
    CardView cardView;
    RecyclerView rView;// = (RecyclerView)findViewById(R.id.recyclerView);

    @Before
    public void setUp(){
        adapter = new CapstoneAdapter(responses);

        //svg = new MyViewGroup();

        //cardView=(CardView) LayoutInflater.from(svg.ctx).inflate(R.layout.card_v,svg,false);
        RoboLayoutInflater inflater = new RoboLayoutInflater(Robolectric.buildActivity(ResultView.class).get());
        cardView =  (CardView)inflater.from(Robolectric.buildActivity(ResultView.class).get()).inflate(R.layout.card_v,null);

        rView = (RecyclerView)inflater.from(Robolectric.buildActivity(ResultView.class).get()).inflate(R.layout.activity_result_view,null).findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(Robolectric.buildActivity(ResultView.class).get());
        //manager.generateDefaultLayoutParams();
        //{
          //  @Override
            //public RecyclerView.LayoutParams generateDefaultLayoutParams() {
              //  return new RecyclerView.LayoutParams(4,8);
            //}
        //};
        //manager.addView(cardView);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(manager);

        //svg.addView(cardView,0,new ViewGroup.LayoutParams(2,4));
        //svg.addView(cardView,1,new ViewGroup.LayoutParams(2,4));
        //svg.addView(cardView,2,new ViewGroup.LayoutParams(2,4));
        //svg.addView(cardView,3,new ViewGroup.LayoutParams(2,4));
    }

    @Test
    public void checkIfgetItemCountReturnsCorrectNumber() throws Exception{
        int itemCount = adapter.getItemCount();
        assertEquals(itemCount,2);
    }

    @Test
    public void onBindViewHolderShouldCreateCardViews() throws Exception{

        //adapter.onCreateViewHolder(Shadows.shadowOf(v),1);
        //assertEquals();
        CapstoneAdapter.ViewHolder holder = adapter.onCreateViewHolder(rView,0);
        //assertEquals(holder,new CapstoneAdapter.ViewHolder(cardView));
        assertNotNull(holder);
        assertTrue(holder.getClass()==(new CapstoneAdapter.ViewHolder(cardView).getClass()));
    }

    //@Implements(ViewGroup.class)
    //private class MyViewGroup extends ShadowViewGroup{
       // ;
        //@RealObject private ViewGroup view;
       //Context ctx = view.getContext();

        //addView(new CardView(this),0,new ViewGroup.LayoutParams(2,4));
        //svg.addView(new CardView(svg.ctx),1,new ViewGroup.LayoutParams(2,4));
        //svg.addView(new CardView(svg.ctx),2,new ViewGroup.LayoutParams(2,4));
        //svg.addView(new CardView(svg.ctx),3,new ViewGroup.LayoutParams(2,4));
    //}

    //@Implements(value=android.support.v7.widget.CardView.class)
    //private class ShadowCardView extends ShadowFrameLayout{

        //@RealObject private CardView cView;

        //@Implementation
               // public CardView getcView(){
            //return cView;
        //}
        //Context context;


    //}

   //ShadowViewGroup shadowViewGrp = Shadows.shadowOf(ViewGroup);

}
