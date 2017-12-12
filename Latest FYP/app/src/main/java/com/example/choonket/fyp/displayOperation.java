package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.choonket.fyp.mMySQL.DownloaderOperation;

public class displayOperation extends AppCompatActivity {
    String urlAddress = "http://10.0.2.2/android_ezshop/retrieveOperation.php?format=json";
    RecyclerView.LayoutManager recyclerViewlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_operation);

        final RecyclerView rv3 = (RecyclerView) findViewById(R.id.rv3);
        rv3.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        rv3.setLayoutManager(recyclerViewlayoutManager);
        new DownloaderOperation(displayOperation.this,urlAddress,rv3).execute();
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
