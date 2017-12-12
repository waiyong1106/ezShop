package com.example.choonket.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class operationDetails extends AppCompatActivity implements AsyncResponse {
    String locationName;

    String tempID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_details);

        Bundle bundle = getIntent().getExtras();
        String data1 = bundle.getString("e1");
        TextView shopname = (TextView) findViewById(R.id.shopName);
        shopname.setText(data1);
        locationName= data1;

        HashMap<String, String> postData = new HashMap<String, String>();

        PostResponseAsyncTask readData =
                new PostResponseAsyncTask(operationDetails.this, postData, operationDetails.this);
        readData.execute("http://10.0.2.2/android_ezshop/retrieveLocationOperation.php");

    }

    public void buttonOnClick(View v) {
        Integer countt = 1;



        EditText MondayOT = (EditText) findViewById(R.id.etMondayST);
        String MondayOT2 = MondayOT.getText().toString();

        EditText MondayET = (EditText) findViewById(R.id.etMondayET);
        String MondayET2 = MondayET.getText().toString();

        EditText TuesdayOT = (EditText)findViewById(R.id.etTuesdayST);
        String TuesdayOT2 = TuesdayOT.getText().toString();
        EditText TuesdayET = (EditText)findViewById(R.id.etTuesdayET);
        String TuesdayET2 = TuesdayET.getText().toString();

        EditText WednesdayOT = (EditText)findViewById(R.id.etWednesdayST);
        String WednesdayOT2 = WednesdayOT.getText().toString();
        EditText WednesdayET = (EditText)findViewById(R.id.etWednesdayET);
        String WednesdayET2 =WednesdayET.getText().toString();

        EditText ThursdayOT = (EditText)findViewById(R.id.etThursdayST);
        String ThursdayOT2 = ThursdayOT.getText().toString();
        EditText ThursdayET = (EditText)findViewById(R.id.etThursdayET);
        String ThursdayET2 = ThursdayET.getText().toString();

        EditText FridayOT = (EditText)findViewById(R.id.etFridayST);
        String FridayOT2 = FridayOT.getText().toString();
        EditText FridayET = (EditText)findViewById(R.id.etFridayET);
        String FridayET2 = FridayET.getText().toString();

        EditText SaturdayOT = (EditText)findViewById(R.id.etSaturdayST);
        String SaturdayOT2 = SaturdayOT.getText().toString();
        EditText SaturdayET = (EditText)findViewById(R.id.etSaturdayET);
        String SaturdayET2 = SaturdayET.getText().toString();


        EditText SundayOT = (EditText)findViewById(R.id.etSundayST);
        String SundayOT2 = SundayOT.getText().toString();
        EditText SundayET = (EditText)findViewById(R.id.etSundayET);
        String SundayET2 = SundayET.getText().toString();

        if (countt == 1) {
            String tempday = "Monday";
            HashMap<String, String> postData = new HashMap<String, String>();
            postData.put("txtOpenTime", MondayOT2.toString());
            postData.put("txtCloseTime", MondayET2.toString());
            postData.put("txtDayOfWeek", tempday);
            postData.put("txtLocationID", tempID);
            PostResponseAsyncTask readData =
                    new PostResponseAsyncTask(operationDetails.this, postData, operationDetails.this);
            readData.execute("http://10.0.2.2/android_ezshop/createOperation.php");
            countt++;
        }
                    if(countt==2){
                        String tempday = "Tuesday";
                HashMap<String, String> postData2= new HashMap<String,String>();
                postData2.put("txtOpenTime",  TuesdayOT2.toString());
                postData2.put("txtCloseTime", TuesdayET2.toString());
                postData2.put("txtDayOfWeek", tempday);
                postData2.put("txtLocationID", tempID);
                PostResponseAsyncTask readData2 =
                        new PostResponseAsyncTask(operationDetails.this, postData2, operationDetails.this);
                readData2.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                countt++;
            }
            if(countt==3){
                String tempday = "Wednesday";
                HashMap<String, String> postData3= new HashMap<String,String>();
                postData3.put("txtOpenTime",  WednesdayOT2.toString());
                postData3.put("txtCloseTime", WednesdayET2.toString());
                postData3.put("txtDayOfWeek", tempday);
                postData3.put("txtLocationID", tempID);
                PostResponseAsyncTask readData3 =
                        new PostResponseAsyncTask(operationDetails.this, postData3, operationDetails.this);
                readData3.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                countt++;
            }
            if(countt==4){
                String tempday = "Thursday";
                HashMap<String, String> postData4= new HashMap<String,String>();
                postData4.put("txtOpenTime",  ThursdayOT2.toString());
                postData4.put("txtCloseTime", ThursdayET2.toString());
                postData4.put("txtDayOfWeek", tempday);
                postData4.put("txtLocationID", tempID);
                PostResponseAsyncTask readData4 =
                        new PostResponseAsyncTask(operationDetails.this, postData4, operationDetails.this);
                readData4.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                countt++;
            }
            if(countt==5){
                String tempday="Friday";
                HashMap<String, String> postData5= new HashMap<String,String>();
                postData5.put("txtOpenTime",  FridayOT2.toString());
                postData5.put("txtCloseTime", FridayET2.toString());
                postData5.put("txtDayOfWeek", tempday);
                postData5.put("txtLocationID", tempID);
                PostResponseAsyncTask readData5 =
                        new PostResponseAsyncTask(operationDetails.this, postData5, operationDetails.this);
                readData5.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                countt++;
            }
            if(countt==6){
                String tempday = "Saturday";
                HashMap<String, String> postData6= new HashMap<String,String>();
                postData6.put("txtOpenTime",  SaturdayOT2.toString());
                postData6.put("txtCloseTime", SaturdayET2.toString());
                postData6.put("txtDayOfWeek", tempday);
                postData6.put("txtLocationID", tempID);
                PostResponseAsyncTask readData6 =
                        new PostResponseAsyncTask(operationDetails.this, postData6, operationDetails.this);
                readData6.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                countt++;
            }
            if(countt==7){
                String tempday = "Sunday";
                HashMap<String, String> postData7= new HashMap<String,String>();
                postData7.put("txtOpenTime",  SundayOT2.toString());
                postData7.put("txtCloseTime", SundayET2.toString());
                postData7.put("txtDayOfWeek", tempday);
                postData7.put("txtLocationID", tempID);
                PostResponseAsyncTask readData7 =
                        new PostResponseAsyncTask(operationDetails.this, postData7, operationDetails.this);
                readData7.execute("http://10.0.2.2/android_ezshop/createOperation.php");
                Toast.makeText(this,"Success process back to mainpage", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(operationDetails.this, MainActivity.class);
                startActivity(intent);
            }
        }

    @Override
    public void processFinish(String result) {
        tempID = result;
        if(result.equals("failed")){
            Toast.makeText(this,"Failed  ", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonOnClick2(View v) {
        EditText MondayOT = (EditText) findViewById(R.id.etMondayST);
        String MondayOT2 = MondayOT.getText().toString();

        EditText MondayET = (EditText) findViewById(R.id.etMondayET);
        String MondayET2 = MondayET.getText().toString();

        EditText TuesdayOT = (EditText)findViewById(R.id.etTuesdayST);
        TuesdayOT.setText(MondayOT2);
        EditText TuesdayET = (EditText)findViewById(R.id.etTuesdayET);
        TuesdayET.setText(MondayET2);

        EditText WednesdayOT = (EditText)findViewById(R.id.etWednesdayST);
        WednesdayOT.setText(MondayOT2);
        EditText WednesdayET = (EditText)findViewById(R.id.etWednesdayET);
        WednesdayET.setText(MondayET2);

        EditText ThursdayOT = (EditText)findViewById(R.id.etThursdayST);
        ThursdayOT.setText(MondayOT2);
        EditText ThursdayET = (EditText)findViewById(R.id.etThursdayET);
        ThursdayET.setText(MondayET2);

        EditText FridayOT = (EditText)findViewById(R.id.etFridayST);
        FridayOT.setText(MondayOT2);
        EditText FridayET = (EditText)findViewById(R.id.etFridayET);
        FridayET.setText(MondayET2);

        EditText SaturdayOT = (EditText)findViewById(R.id.etSaturdayST);
        SaturdayOT.setText(MondayOT2);
        EditText SaturdayET = (EditText)findViewById(R.id.etSaturdayET);
        SaturdayET.setText(MondayET2);


        EditText SundayOT = (EditText)findViewById(R.id.etSundayST);
        SundayOT.setText(MondayOT2);
        EditText SundayET = (EditText)findViewById(R.id.etSundayET);
        SundayET.setText(MondayET2);

        Toast.makeText(this,"meow"+tempID, Toast.LENGTH_LONG);

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
