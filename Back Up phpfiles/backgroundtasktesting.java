package com.example.choonket.fyp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mr.Tsang Wai Yong on 1/11/2017.
 */

public class BackgroundTask extends AsyncTask<Void,Void,Void>{
    String data="";
    String dataParsed = "";
    String singleParsed ="";

    @Override
    protected Void doInBackground(Void... voids) {

        try{
            URL url = new URL("http://10.0.2.2/android_ezshop/retrievelocation.php?format=json");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;

            }
            JSONArray JA = new JSONArray(data);
        for(int i = 0; i< shopDetails.data2; i++){
            JSONObject JO = (JSONObject) JA.get(i);
            singleParsed = "Name : " + JO.get("locationName") +"\n" +
                    "Address : " + JO.get("locationAddress") +"\n" +
                    "Category : " + JO.get("locationCategory") +"\n" +
                    "Description : " + JO.get("locationDescription") +"\n"+
                    "Owner : " + JO.get("locationOwner") +"\n" +
                    "EmailAddress : " + JO.get("locationEmailAddress") +"\n" +
                    "Contact : " + JO.get("locationContact") +"\n"
            ;
            dataParsed = dataParsed + singleParsed +"\n";
        }
        
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
//        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show()
    super.onPostExecute(aVoid);
        shopDetails.data.setText(this.dataParsed);
    }
}
