package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.choonket.fyp.mDataObject.globalVariable;
import com.example.choonket.fyp.mMySQL.DownloaderTracking;

public class displayTracking extends AppCompatActivity {

    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static double currentLongtiude = 0;
    public static double currentLatitude = 0;
    String urlAddress= "http://10.0.2.2/android_ezshop/retrieveLocationCordinator.php";
    Spinner spinner,spinner2;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tracking);
        spinner = (Spinner)findViewById(R.id.spinnerDistance);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinnertd,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner for dropdownlist;
        spinner2 = (Spinner)findViewById(R.id.spinnerCategoryT);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinnerCat,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        final RecyclerView rv2 = (RecyclerView) findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        rv2.setLayoutManager(recyclerViewlayoutManager);

        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3,menu);
        return true;
    }

    public void buttonOnClick(View v){
        String tempDistance= spinner.getSelectedItem().toString();
        double tempDistance1 = 0;
        if(tempDistance.equals("All")){
            tempDistance1=0;
            globalVariable.tempDistance = tempDistance1;
        }else if(tempDistance.equals("10 KM")){
            tempDistance1=10;
            globalVariable.tempDistance = tempDistance1;

        }else if(tempDistance.equals("20 KM")){
            tempDistance1=20;
            globalVariable.tempDistance = tempDistance1;

        }else if(tempDistance.equals("50 KM")){
            tempDistance1=50;
            globalVariable.tempDistance = tempDistance1;

        }else if(tempDistance.equals("100 KM")){
            tempDistance1=100;
            globalVariable.tempDistance = tempDistance1;
        }
        System.out.println(tempDistance1);

        String tempCategory= spinner2.getSelectedItem().toString();
            if(tempCategory.equals("All")){
                globalVariable.tempLocationCategory = tempCategory;
            }else if(tempCategory.equals("Food and Beverages")){
                globalVariable.tempLocationCategory = tempCategory;

            }else if(tempCategory.equals("Clothes")){
             globalVariable.tempLocationCategory = tempCategory;

             }else if(tempCategory.equals("Etc")){
                globalVariable.tempLocationCategory = tempCategory;

            }else if(tempCategory.equals("Electronic")){
                globalVariable.tempLocationCategory = tempCategory;
            }

        final RecyclerView rv2 = (RecyclerView) findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        rv2.setLayoutManager(recyclerViewlayoutManager);
        new DownloaderTracking(displayTracking.this,urlAddress,rv2).execute();

        adapter.notifyDataSetChanged();

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
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.map:
                startActivity(new Intent(this,MarkerActivity.class));
                break;

        }
        return true;
    }
}
