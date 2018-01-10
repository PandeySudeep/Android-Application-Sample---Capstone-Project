package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;


class CapstoneAdapter extends RecyclerView.Adapter<CapstoneAdapter.ViewHolder> {

    private Webresponse[] responses;

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

    }
}
