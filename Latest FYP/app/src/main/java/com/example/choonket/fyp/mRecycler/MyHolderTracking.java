package com.example.choonket.fyp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.choonket.fyp.R;

/**
 * Created by Mr.Tsang Wai Yong on 25/11/2017.
 */

public class MyHolderTracking extends RecyclerView.ViewHolder{


    TextView tvTLocationName2,tvTContact2,tvTAddress2,tvTracking2;
    RecyclerView Trv2;
    RatingBar ttRatingBar;

    public MyHolderTracking(View itemView){
        super(itemView);
        Trv2 =(RecyclerView)itemView.findViewById(R.id.rv2);
        tvTLocationName2 =(TextView) itemView.findViewById(R.id.tvTLocationName);
        tvTContact2 = (TextView) itemView.findViewById(R.id.tvTContact);
        tvTAddress2 =(TextView) itemView.findViewById(R.id.tvTAddress);
        tvTracking2 =(TextView) itemView.findViewById(R.id.tvTrackingDistance);
        ttRatingBar = (RatingBar)itemView.findViewById(R.id.trackingRatingBar);
    }

}