package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createShops extends AppCompatActivity implements AsyncResponse {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String name,address,category,description;
    String lat, longt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shops);

        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner for dropdownlist;
        spinner = (Spinner)findViewById(R.id.spinner);

        Bundle bundle = getIntent().getExtras();
        String data1 = bundle.getString("e1");
        String data2 = bundle.getString("e2");
        String data3 = bundle.getString("e3");
        String data4 = bundle.getString("e4");
        name = data1;
        address = data2;
        lat = data3;
        longt = data4;

        EditText shopname = (EditText)findViewById(R.id.shopname);
        TextView shopaddr = (TextView) findViewById(R.id.tvDisplayLocationAddress);
        shopname.setText(data1);
        shopaddr.setText(data2);

        HashMap<String, String> postData= new HashMap<String,String>();
        postData.put("mobile", "android");
        postData.put("txtLocationAddress",  data2.toString());
        PostResponseAsyncTask readData =
                new PostResponseAsyncTask(createShops.this, postData, createShops.this);
        readData.execute("http://10.0.2.2/android_ezshop/checkLocationAddressexist.php");

    }

    public void buttonOnClick(View v){

        category = spinner.getSelectedItem().toString();
        EditText description = (EditText)findViewById(R.id.etDescription);
        String description2 = description.getText().toString();

        EditText owner = (EditText)findViewById(R.id.etOwnerName);
        String owner2 = owner.getText().toString();

        EditText emailAddress = (EditText)findViewById(R.id.etEmailAddress);
        String emailAddress2 = emailAddress.getText().toString();

        EditText contact = (EditText)findViewById(R.id.etContact);
        String contact2 = contact.getText().toString();

        EditText shopname = (EditText)findViewById(R.id.shopname);
        String shopname2 =  shopname.getText().toString();

        String emailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress2;
        Pattern pattern = Pattern.compile(emailExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        int temp1 = 0;
        if(shopname2.equals("")){
            Toast.makeText(this,"Enter shopname",Toast.LENGTH_SHORT).show();
            temp1+=1;
        }
        if(description2.equals("")){
            Toast.makeText(this,"Enter description",Toast.LENGTH_SHORT).show();
            temp1+=1;
        }
        if(owner2.equals("")){
            Toast.makeText(this,"Enter owner name",Toast.LENGTH_SHORT).show();
            temp1+=1;
        }if(emailAddress2.equals("")){
            Toast.makeText(this,"Enter email address",Toast.LENGTH_SHORT).show();
            temp1+=1;
        }if(contact2.equals("")){
            Toast.makeText(this,"Enter contact",Toast.LENGTH_SHORT).show();
            temp1+=1;
        }if(contact2.length()<10){
            Toast.makeText(this,"Contact format is wrong",Toast.LENGTH_SHORT).show();
        }else if(matcher.matches() && temp1 == 0) {
            HashMap<String, String> postData = new HashMap<String, String>();
            postData.put("txtLocationName", shopname2.toString());
            postData.put("txtLocationAddress", address.toString());
            postData.put("txtLocationCategory", category.toString());
            postData.put("txtLocationDescription", description2.toString());
            postData.put("txtLocationOwner", owner2.toString());
            postData.put("txtLocationEmailAddress", emailAddress2.toString());
            postData.put("txtLocationContact", contact2.toString());
            postData.put("txtLatitude", lat.toString());
            postData.put("txtLongtitude", longt.toString());

            PostResponseAsyncTask readData =
                    new PostResponseAsyncTask(createShops.this, postData, createShops.this);
            readData.execute("http://10.0.2.2/android_ezshop/createLocation.php");

            // Toast.makeText(this,"Shop successfully created  "+ name +currentI, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(createShops.this, operationDetails.class); //Change to the location you want to intend
            intent.putExtra("e1", shopname2);
            startActivity(intent);
        }else{
            Toast.makeText(this,"check your email format",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void processFinish(String result) {

        if(result.equals("success")){
            Toast.makeText(this,"location is exist, back to mainpage "  , Toast.LENGTH_LONG).show();
            Intent intent = new Intent(createShops.this, MainActivity.class); //Change to the location you want to intend
            startActivity(intent);
        }else{
            Toast.makeText(this,"Welcome to Create Shop "  , Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonOnClick2(View v){
        Intent intent = new Intent(createShops.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuLogout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.tracking:
                startActivity(new Intent(this,displayTracking.class));
                break;
            case R.id.main:
                startActivity(new Intent(this,createShops.class));
                break;
            case R.id.map:
                startActivity(new Intent(this,MarkerActivity.class));
                break;

        }
        return true;
    }

}

