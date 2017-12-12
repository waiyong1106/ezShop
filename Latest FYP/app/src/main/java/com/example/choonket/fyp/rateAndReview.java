package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.choonket.fyp.mDataObject.globalVariable;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class rateAndReview extends AppCompatActivity implements AsyncResponse {
    ListView lv;
    Integer selectedIndex;
    String averageRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_and_review);
        Bundle bundle = getIntent().getExtras();
        int valid = bundle.getInt("Valid");


        if(valid == 2){
            String data1 = bundle.getString("e1");
            selectedIndex = bundle.getInt("e2");
            globalVariable.rarLocationID = selectedIndex;
            selectedIndex +=1;
            globalVariable.rarLocationName =data1;
            TextView locationName = (TextView) findViewById(R.id.tvRaRLocationName);
            locationName.setText(data1);
            TextView locationDescription = (TextView) findViewById(R.id.tvRARLocationDescription);
            locationDescription.setText(selectedIndex + "");

            HashMap<String, String> postData = new HashMap<String, String>();
            postData.put("txtLocationID", selectedIndex.toString());
            PostResponseAsyncTask readData =
                    new PostResponseAsyncTask(rateAndReview.this, postData, rateAndReview.this);
            readData.execute("http://10.0.2.2/android_ezshop/retrieveLocationID.php");
        }
        else if (valid == 1)
        {
            String data1 = bundle.getString("LocationName");
            selectedIndex = bundle.getInt("LocationID");
            globalVariable.rarLocationID = selectedIndex+1;
            globalVariable.rarLocationName =data1;
            TextView locationName = (TextView) findViewById(R.id.tvRaRLocationName);
            locationName.setText(data1);
            TextView locationDescription = (TextView) findViewById(R.id.tvRARLocationDescription);
            locationDescription.setText(selectedIndex + "");


            HashMap<String, String> postData = new HashMap<String, String>();
            postData.put("txtLocationID", selectedIndex.toString());
            PostResponseAsyncTask readData =
                    new PostResponseAsyncTask(rateAndReview.this, postData, rateAndReview.this);
            readData.execute("http://10.0.2.2/android_ezshop/retrieveLocationID.php");
        }

    }

    public void buttonOnClick(View v) {

        EditText review = (EditText) findViewById(R.id.etRARReview);
        String review2 = review.getText().toString();

        RatingBar ratingBar = (RatingBar) findViewById(R.id.rbRARRating);
        Float ratingBar2 =ratingBar.getRating();

        HashMap<String, String> postData = new HashMap<String, String>();
        //Rating
        postData.put("txtRating", ratingBar2.toString());
        postData.put("txtReview", review2.toString());
        postData.put("txtLocationID", selectedIndex.toString());
        PostResponseAsyncTask readData =
                new PostResponseAsyncTask(rateAndReview.this, postData, rateAndReview.this);
        readData.execute("http://10.0.2.2/android_ezshop/createReviewRating.php");


        if(averageRating.equals("no review and rating :<")) {
            HashMap<String, String> postData2 = new HashMap<String, String>();
            postData2.put("txtRating", ratingBar2.toString());
            postData2.put("txtLocationID", selectedIndex.toString());
            PostResponseAsyncTask readData2 =
                    new PostResponseAsyncTask(rateAndReview.this, postData2, rateAndReview.this);
            readData2.execute("http://10.0.2.2/android_Ezshop/createAverageRating.php");

        }else{
            HashMap<String, String> postData2 = new HashMap<String, String>();
            postData2.put("txtRating", averageRating.toString());
            postData2.put("txtLocationID", selectedIndex.toString());
            PostResponseAsyncTask readData2 =
                    new PostResponseAsyncTask(rateAndReview.this, postData2, rateAndReview.this);
            readData2.execute("http://10.0.2.2/android_Ezshop/createAverageRating.php");
        }
    }

    @Override
    public void processFinish(String result) {
        if(result!=null) {
            TextView locationDescription = (TextView) findViewById(R.id.tvRARLocationDescription);
            locationDescription.setText("Average Rating :"+result+System.getProperty("line.separator"));
            averageRating = result;
        }else if (result.equals("insert success")){
            TextView locationDescription = (TextView) findViewById(R.id.tvRARLocationDescription);
            locationDescription.setText(result+"Average Rating : "+result);
            Toast.makeText(this,"Response :"+result, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,"Failed  "+result, Toast.LENGTH_SHORT).show();
//      }
    }
    public void buttonOnClick2(View v) {

        Toast.makeText(rateAndReview.this,"Process to Rate and Review.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(rateAndReview.this, displayRateReview.class);
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
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.map:
                startActivity(new Intent(this,MarkerActivity.class));
                break;

        }
        return true;
    }

}

