package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sudeep.Pandey on 1/10/2018.
 */

//public class CapstoneAdapter {
//}


//package com.vand.capst.capstoneproject_vanderbiltuniversity;

  //      import android.content.Intent;
    //    import android.graphics.Paint;
      //  import android.support.v7.widget.CardView;
        //import android.support.v7.widget.RecyclerView;
        //import android.view.LayoutInflater;
        //import android.view.View;
        //import android.view.ViewGroup;
        //import android.widget.TextView;

/**
 * Created by Sudeep.Pandey on 12/26/2017.
 */

class CapstoneAdapter extends RecyclerView.Adapter<CapstoneAdapter.ViewHolder> {

    private Webresponse[] responses;
    //private Listener listener;

   // interface Listener{
     //   void onClick(int position);
    //}

    public CapstoneAdapter(Webresponse[] responsecollection){
        this.responses=responsecollection;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView cv){
            super(cv);
            this.cardView=cv;
        }
    }

    @Override
    public int getItemCount(){
        return responses.length;
    }

    //public void setListener(Listener listener){
      //  this.listener=listener;
    //}

    @Override
    public CapstoneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        CardView cdvw = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_v,parent,false);
        return new ViewHolder(cdvw);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){

        final CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.web_response);
        textView.setText(responses[position].getName());
        /*cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(cardView.getContext(),LastActivity.class);
                //intent.putExtra(LastActivity.EXTRA_RESPONSE,position);
                //cardView.getContext().startActivity(intent);
                if(listener!=null){
                    listener.onClick(position);
                }
            }
        });*/

    }
}
