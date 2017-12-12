package com.example.choonket.fyp.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.choonket.fyp.mDataObject.globalVariable;
import com.example.choonket.fyp.mDataObject.ratingaReview;
import com.example.choonket.fyp.mRecycler.MyAdapterRAR;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class DataParserRAR extends AsyncTask<Void,Void,Integer>{
    Context c;
    RecyclerView rv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<ratingaReview> ratingaReviews=new ArrayList<>();

    public DataParserRAR(Context c, RecyclerView rv, String jsonData) {
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
        if(result==0)
        {
            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
        }else {
            MyAdapterRAR adapter=new MyAdapterRAR(c,ratingaReviews);
            rv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            ratingaReviews.clear();
            ratingaReview s=null;
            int tempRARLocationID = 0;
            tempRARLocationID = globalVariable.rarLocationID+1;
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int rid=jo.getInt("reviewID");
                int rating=jo.getInt("rating");
                String review=jo.getString("review");
                String rrdate = jo.getString("rrDate");
                int lid = jo.getInt("locationID");
                s=new ratingaReview();


                if(lid == tempRARLocationID){
                    s.setRid(rid);
                    s.setRating(rating);
                    s.setReview(review);
                    s.setRrDate(rrdate);
                    s.setLid(lid);
                    ratingaReviews.add(s);
                }

            }
            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
