package com.example.choonket.fyp.mMySQL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mr.Tsang Wai Yong on 19/11/2017.
 */

public class Connector3 {

    public static HttpURLConnection connect(String urlAddress)
    {
        try {
            URL url=new URL(urlAddress);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            //SET PROPS
            con.setRequestMethod("GET");
            con.setConnectTimeout(20000);
            con.setReadTimeout(20000);
            con.setDoInput(true);

            return con;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
