package com.example.choonket.fyp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.choonket.fyp.app.AppController;
import com.example.choonket.fyp.mDataObject.globalVariable;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MarkerActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapFragment mapFragment;
    GoogleMap gMap;
    MarkerOptions markerOptions=new MarkerOptions();
    LatLng  latLng;
    String title,category;
    int id;
    LatLng myPosition;

    public static final String ID = "LocationID";
    public static final String TITLE = "LocationName";
    public static final String CATEGORY = "LocationCategory";
    public static final String LAT = "Latitude";
    public static final String LNG = "Longtitude";
    private String url = "http://10.0.2.2/android_ezshop/Marker.php";
    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.main:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.tracking:
                startActivity(new Intent(this,displayTracking.class));
                break;
            case R.id.menuLogout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this,Login.class));
                break;
        }
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        gMap = googleMap;
        //center = new LatLng(3.2151, 101.7265);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) return;
        gMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if(location!=null){
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            globalVariable.trackinglatitude = latitude ;
            globalVariable.trackingLongtitude = longitude;

            LatLng latLng = new LatLng(latitude, longitude);
            myPosition = new LatLng(latitude, longitude);
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 5);
            gMap.animateCamera(yourLocation);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLng)      // Sets the center of the map to Mountain View
                    .zoom(17)                   // Sets the zoom
                    .bearing(90)                // Sets the orientation of the camera to east
                    .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                    .build();                   // Creates a CameraPosition from the builder
            gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        //gMap.getUiSettings().setMyLocationButtonEnabled(true);
        //cameraPosition = new CameraPosition.Builder().target(center).zoom(15).build();
        //googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        getMarkers();

    }

    public void addMarker(LatLng latLng,final String title,final String category,final int id){
        markerOptions.zIndex(id);
        markerOptions.position(latLng);
        markerOptions.title(title);
        markerOptions.snippet(category +" "+"\n"+"Click here to view Shop Details");
        gMap.addMarker(markerOptions);

        gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
            @Override
            public void onInfoWindowClick(Marker marker) {
                int test = Math.round(marker.getZIndex());

                int valid = 1;
                Intent intent = new Intent(MarkerActivity.this,shopDetails.class);
                intent.putExtra("Valid",valid);
                intent.putExtra("LocationName",marker.getTitle());
                intent.putExtra("LocationID",test);
                startActivity(intent);
            }
        });
        gMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }
            @Override
            public View getInfoContents(Marker marker) {
                Context context = getApplicationContext();

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

    }
    private void getMarkers(){
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                Log.e("Response: ", response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    String getObject = jObj.getString("location");
                    JSONArray jsonArray = new JSONArray(getObject);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id = jsonObject.getInt(ID);
                        title = jsonObject.getString(TITLE);
                        category = jsonObject.getString(CATEGORY);
                        latLng = new LatLng(Double.parseDouble(jsonObject.getString(LAT)), Double.parseDouble(jsonObject.getString(LNG)));
                        addMarker(latLng, title,category,id);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.e("Error: ", error.getMessage());
                Toast.makeText(MarkerActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);

    }
}
