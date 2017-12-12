package com.example.choonket.fyp.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.choonket.fyp.mDataObject.operationDetail;
import com.example.choonket.fyp.mRecycler.MyAdapterOperation;
import com.example.choonket.fyp.shopDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class DataParserOperation extends AsyncTask<Void,Void,Integer>{
    Context c;
    RecyclerView rv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<operationDetail> operationDetails =new ArrayList<>();

    public DataParserOperation(Context c, RecyclerView rv, String jsonData) {
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
        if (result == 0) {
            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();
        } else {
            ArrayList<operationDetail> temp = new ArrayList();
            for (int i = 0; i < operationDetails.size(); i++) {
                if (operationDetails.get(i).getLocationID() == shopDetails.data2+1) {
                    temp.add(operationDetails.get(i));
                    MyAdapterOperation adapter = new MyAdapterOperation(c, temp);
                    rv.setAdapter(adapter);
                }
            }
        }

    }
    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            operationDetails.clear();
            operationDetail s=null;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int Oid=jo.getInt("operationID");
                String dow=jo.getString("dayOfWeek");
                String ot=jo.getString("openTime");
                String ct = jo.getString("closeTime");
                int lid = jo.getInt("locationID");

                s=new operationDetail();

                    s.setOperationID(Oid);
                    s.setDayOfWeek(dow);
                    s.setOpenTime(ot);
                    s.setCloseTime(ct);
                    s.setLocationID(lid);
                    operationDetails.add(s);
            }
            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
