package com.example.choonket.fyp.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.choonket.fyp.R;
import com.example.choonket.fyp.mDataObject.operationDetail;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class MyAdapterOperation extends RecyclerView.Adapter<MyHolderOperation>{

    Context c;
    ArrayList<operationDetail> operationDetails;

    public MyAdapterOperation(Context c,  ArrayList<operationDetail> operationDetails) {
        this.c = c;
        this.operationDetails = operationDetails;
    }

    @Override
    public MyHolderOperation onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model2,parent,false);
        return new MyHolderOperation(v);
    }

    @Override
    public void onBindViewHolder(MyHolderOperation holder, int position) {
            holder.tvDayOFWeek.setText(operationDetails.get(position).getDayOfWeek());
            holder.tvOpenTime.setText(operationDetails.get(position).getOpenTime());
            holder.tvCloseTime.setText(operationDetails.get(position).getCloseTime());

    }

    @Override
    public int getItemCount() {
        return operationDetails.size();

    }



}
