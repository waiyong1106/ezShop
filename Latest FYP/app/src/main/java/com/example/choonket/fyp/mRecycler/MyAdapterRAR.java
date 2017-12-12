package com.example.choonket.fyp.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.choonket.fyp.R;
import com.example.choonket.fyp.mDataObject.ratingaReview;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class MyAdapterRAR extends RecyclerView.Adapter<MyHolderRAR>{

    Context c;
    ArrayList<ratingaReview> ratingaReviews;

    public MyAdapterRAR(Context c, ArrayList<ratingaReview> ratingaReviews) {
        this.c = c;
        this.ratingaReviews = ratingaReviews;
    }

    @Override
    public MyHolderRAR onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolderRAR(v);
    }

    @Override
    public void onBindViewHolder(MyHolderRAR holder, int position) {

        if (ratingaReviews != null){
            holder.mRatingBar2.setRating(ratingaReviews.get(position).getRating());
            holder.tvReview2.setText(ratingaReviews.get(position).getReview());
            holder.tvRRDate2.setText(ratingaReviews.get(position).getRrDate());
        }else {
            holder.tvReview2.setText("Testing meow");
        }
    }



    @Override
    public int getItemCount() {
        return ratingaReviews.size();

    }



}
