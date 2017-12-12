package com.example.choonket.fyp.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.choonket.fyp.mDataObject.Tracking;
import com.example.choonket.fyp.mDataObject.globalVariable;
import com.example.choonket.fyp.mRecycler.MyAdapterTracking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 25/11/2017.
 */

public class DataParserTracking extends AsyncTask<Void,Void,Integer> {
        Context c;
        RecyclerView rv;
        String jsonData;
        ProgressDialog pd;
        ArrayList<Tracking> trackings=new ArrayList<>();

public DataParserTracking(Context c, RecyclerView rv, String jsonData) {
        this.c = c;
        this.rv = rv;
        this.jsonData = jsonData;
        }

@Override
protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
        }

@Override
protected Integer doInBackground(Void... params) {

        return this.parseData();
        }

@Override
protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result==0) {
        Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
        }else {

               if(globalVariable.tempLocationCategory.equals("All") && globalVariable.tempDistance == 0){
                       MyAdapterTracking adapter=new MyAdapterTracking(c,trackings);
                       rv.setAdapter(adapter);
               }else{
                       ArrayList<Tracking> temp = new ArrayList();
                       for (int i=0; i < trackings.size(); i++){
                               if(trackings.get(i).getLocationCategory().equals(globalVariable.tempLocationCategory) && trackings.get(i).getTrackingDistance() < globalVariable.tempDistance){
                                       temp.add(trackings.get(i));
                                       MyAdapterTracking adapter=new MyAdapterTracking(c,temp);
                                       rv.setAdapter(adapter);
                               }else if(globalVariable.tempLocationCategory.equals("All")&& trackings.get(i).getTrackingDistance() < globalVariable.tempDistance){
                                       temp.add(trackings.get(i));
                                       MyAdapterTracking adapter=new MyAdapterTracking(c,temp);
                                       rv.setAdapter(adapter);
                               }else if(trackings.get(i).getLocationCategory().equals(globalVariable.tempLocationCategory) && globalVariable.tempDistance == 0){
                                       temp.add(trackings.get(i));
                                       MyAdapterTracking adapter=new MyAdapterTracking(c,temp);
                                       rv.setAdapter(adapter);

                               }
                       }
               }


        }
        }

private int parseData()
{
        Location locationA = new Location("point A");
        locationA.setLongitude(globalVariable.trackingLongtitude);
        locationA.setLatitude(globalVariable.trackinglatitude);


        try {
                JSONArray ja=new JSONArray(jsonData);
                JSONObject jo=null;

                trackings.clear();
                Tracking s=null;

                for(int i=0;i<ja.length();i++)
                {
                        jo=ja.getJSONObject(i);

                        int tLocationID=jo.getInt("locationID");
                        String tLocationName=jo.getString("locationName");
                        String tLocationContact = jo.getString("locationContact");
                        String tLocationAddress = jo.getString("locationAddress");
                        String tLocationDescription = jo.getString("locationDescription");

                        double tlongtitude = jo.getDouble("longtitude");
                        double tlatitude=jo.getDouble("latitude");
                        String tCategory= jo.getString("locationCategory");
                        double tAverageRating = jo.getDouble("averageRating");
                        Location locationB = new Location("point B");
                        locationB.setLatitude(tlatitude);
                        locationB.setLongitude(tlongtitude);

                        double distance = 0;
                        distance =locationA.distanceTo(locationB)/1000;
                        distance = Math.round(distance*100.0);
                        distance = distance/100.0;

                        s=new Tracking();
                        s.setLocationID(tLocationID);
                        s.setLocationName(tLocationName);
                        s.setTrackingDistance(distance);
                        s.setLocationAddress(tLocationAddress);
                        s.setLocationContact(tLocationContact);
                        s.setLongtitude(tlongtitude);
                        s.setLatitude(tlatitude);
                        s.setLocationDescription(tLocationDescription);
                        s.setLocationCategory(tCategory);
                        s.setAverageRating(tAverageRating);

                        trackings.add(s);
                }

                return 1;


        } catch (JSONException e) {
                e.printStackTrace();
        }

        return 0;
}


        }
