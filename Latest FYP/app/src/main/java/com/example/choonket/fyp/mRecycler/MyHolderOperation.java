package com.example.choonket.fyp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.choonket.fyp.R;

/**
 * Created by Mr.Tsang Wai Yong on 25/11/2017.
 */

public class MyHolderOperation extends RecyclerView.ViewHolder{

    TextView tvOpenTime,tvCloseTime,tvDayOFWeek;
    RecyclerView Trv3;


    public MyHolderOperation(View itemView){
        super(itemView);
        tvOpenTime =(TextView) itemView.findViewById(R.id.openTime);
        tvCloseTime = (TextView) itemView.findViewById(R.id.closeTime);
        tvDayOFWeek =(TextView) itemView.findViewById(R.id.dayOfweek);

    }

}