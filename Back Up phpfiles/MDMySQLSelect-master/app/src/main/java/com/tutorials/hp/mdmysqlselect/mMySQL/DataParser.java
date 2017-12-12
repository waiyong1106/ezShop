package com.tutorials.hp.mdmysqlselect.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.tutorials.hp.mdmysqlselect.mDataObject.Spacecraft;
import com.tutorials.hp.mdmysqlselect.mListView.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataParser  extends AsyncTask<Void,Void,Integer>{

    Context c;
    ListView lv;
    String jsonData;

    ProgressDialog pd;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

    public DataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
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
            //CALL ADAPTER TO BIND DATA
            CustomAdapter adapter=new CustomAdapter(c,spacecrafts);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            spacecrafts.clear();
            Spacecraft s=null;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String propellant=jo.getString("propellant");
                String description=jo.getString("description");

                s=new Spacecraft();
                s.setId(id);
                s.setName(name);
                s.setPropellant(propellant);
                s.setDescription(description);

                spacecrafts.add(s);


            }

            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}















