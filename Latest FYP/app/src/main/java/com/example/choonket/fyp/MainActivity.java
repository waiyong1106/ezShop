package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class MainActivity extends AppCompatActivity{

    private final int REQUEST_CODE_PLACEPICKER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button gotoButton = (Button) findViewById(R.id.go_to_button);
        TextView text = (TextView)findViewById(R.id.name);
        final String s1 = text.getText().toString();
        gotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlacePickerActivity();
            }
        });
    }

    private void startPlacePickerActivity() {
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        // this would only work if you have your Google Places API working

        try {
            Intent intent = intentBuilder.build(this);
            startActivityForResult(intent, REQUEST_CODE_PLACEPICKER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PLACEPICKER && resultCode == RESULT_OK) {
            displaySelectedPlaceFromPlacePicker(data);
        }
    }

    private void displaySelectedPlaceFromPlacePicker(Intent data) {
        Place placeSelected = PlacePicker.getPlace(data, this);

        final String name = placeSelected.getName().toString();
        final String address = placeSelected.getAddress().toString();
        final double latitude = placeSelected.getLatLng().latitude;
        final double longtitude = placeSelected.getLatLng().longitude;

        final String lat = Double.toString(latitude);
        final String longti = Double.toString(longtitude);


        final TextView currentaddress = (TextView) findViewById(R.id.address);
        final TextView currentname = (TextView) findViewById(R.id.name);

        currentaddress.setText("Address :"+address);
        currentname.setText("Name :"+name);

        Button goCreate = (Button)findViewById(R.id.goCreate);
        goCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentaddress.getText().length()<5){
                    Toast.makeText(MainActivity.this,"Select place from pick a place.",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, createShops.class);
                    intent.putExtra("e1", name);
                    intent.putExtra("e2", address);
                    intent.putExtra("e3",lat);
                    intent.putExtra("e4",longti);
                    Toast.makeText(MainActivity.this,"Process to create shop.",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

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
            case R.id.map:
                startActivity(new Intent(this,MarkerActivity.class));
                break;

        }
        return true;
    }

}
