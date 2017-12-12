package com.example.choonket.fyp.mRecycler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.choonket.fyp.R;
import com.example.choonket.fyp.mDataObject.Tracking;
import com.example.choonket.fyp.shopDetails;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 25/11/2017.
 */

public class MyAdapterTracking  extends RecyclerView.Adapter<MyHolderTracking> {

    Context c;
    ArrayList<Tracking> trackings;

    public MyAdapterTracking(Context c, ArrayList<Tracking> trackings) {
        this.c = c;
        this.trackings = trackings;
    }

    @Override
    public MyHolderTracking onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new MyHolderTracking(v);
    }

    @Override
    public void onBindViewHolder(final MyHolderTracking holder, final int position) {

        holder.tvTLocationName2.setText(trackings.get(position).getLocationName());
        holder.tvTContact2.setText(trackings.get(position).getLocationContact());
        holder.tvTAddress2.setText(trackings.get(position).getLocationAddress());
        holder.tvTracking2.setText(trackings.get(position).getTrackingDistance()+" KM");
        String temp2 = trackings.get(position).getAverageRating().toString();
        float temp1 = Float.parseFloat(temp2);
        holder.ttRatingBar.setRating(temp1);

        holder.tvTLocationName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                a_builder.setMessage("Opening  Shop Details ")
                        .setCancelable(false).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Integer tempLocationID =trackings.get(position).getLocationID();
                                String tempLocationName = trackings.get(position).getLocationName()+1;
                                Integer tempValid =2;
                                Intent intent = new Intent(c, shopDetails.class);
                                intent.putExtra("e1", tempLocationName);
                                intent.putExtra("e2", tempLocationID);
                                intent.putExtra("Valid",tempValid);
                                c.startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Choose your path");
                alert.show();

            }

        });

        holder.tvTAddress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                a_builder.setMessage("Opening google maps ")
                        .setCancelable(false).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                double temp1 = 0, temp2 = 0;
                                temp1 = trackings.get(position).getLatitude();
                                temp2 = trackings.get(position).getLongtitude();
                                String uri = "http://maps.google.com/maps?q=loc:" + temp1 + "," + temp2;
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                intent.setData(Uri.parse(uri));
                                c.startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Choose your path");
                alert.show();
                ;

            }

        });

        holder.tvTContact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                a_builder.setMessage("Opening  Contact Selection ")
                        .setCancelable(false).
                        setPositiveButton("Phone Call", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String tempphone = null;
                                tempphone = trackings.get(position).getLocationContact();
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tempphone, null));
                                c.startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setNeutralButton("Message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String tempphone = null;
                        tempphone = trackings.get(position).getLocationContact();

                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                        smsIntent.setType("vnd.android-dir/mms-sms");
                        smsIntent.setData(Uri.parse("sms:" + tempphone));
                        c.startActivity(smsIntent);

                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Choose your path");
                alert.show();
                ;

            }

        });

    }
    @Override
    public int getItemCount() {
        return trackings.size();

    }



}
