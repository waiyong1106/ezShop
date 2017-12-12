package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.choonket.fyp.mDataObject.globalVariable;
import com.example.choonket.fyp.mMySQL.Downloader;

public class displayRateReview extends AppCompatActivity {

    RecyclerView.LayoutManager recyclerViewlayoutManager;
    String urlAddress= "http://10.0.2.2/android_ezshop/retrieveRateReview.php";
    public static Integer locationIDvalidation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rate_review);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        TextView tv = (TextView)findViewById(R.id.tvRARLocationNameTitle);
        tv.setText(globalVariable.rarLocationName);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(recyclerViewlayoutManager);
        new Downloader(displayRateReview.this,urlAddress,rv).execute();
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
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.map:
                startActivity(new Intent(this,MarkerActivity.class));
                break;

        }
        return true;
    }

}
