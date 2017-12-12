package com.example.choonket.fyp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.choonket.fyp.R;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class MyHolderRAR extends RecyclerView.ViewHolder{

    TextView tvReviewID2,tvReview2,tvRRDate2;
    RatingBar mRatingBar2;

    public MyHolderRAR(View itemView){
        super(itemView);


        tvReview2 = (TextView) itemView.findViewById(R.id.tvReview);
        tvRRDate2 =(TextView) itemView.findViewById(R.id.tvRRDATE);
        mRatingBar2 = (RatingBar)itemView.findViewById(R.id.mRatingbar);
        }

}
