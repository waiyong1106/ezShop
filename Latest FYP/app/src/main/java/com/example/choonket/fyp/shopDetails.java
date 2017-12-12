package com.example.choonket.fyp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.choonket.fyp.mDataObject.globalVariable;

public class shopDetails extends AppCompatActivity {
    Button click;
    public static TextView data;
    public static int data2;
    public static TextView data3;
    public String data1;
    public static RatingBar rb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        Bundle bundle = getIntent().getExtras();
        int valid = bundle.getInt("Valid");
        if(valid == 1){
             data1 = bundle.getString("LocationName");
            data2 = bundle.getInt("LocationID");
            data2 = data2 - 1;
        }
        else if(valid == 2) {
             data1 = bundle.getString("e1");
            data2 = bundle.getInt("e2");
            data2 = data2 - 1;

        }
        data = (TextView) findViewById(R.id.tvSDShopname);
        data3 = (TextView)findViewById(R.id.tvTestingSD);
        click = (Button)findViewById(R.id.btnSDConfirm);

                BackgroundTask process = new BackgroundTask();
                process.execute();

    }

    public void buttonOnClick(View v){
            Integer tempValid =2;
            Intent intent = new Intent(shopDetails.this, rateAndReview.class);
            intent.putExtra("e1", data1);
            intent.putExtra("e2", data2);
            intent.putExtra("Valid",tempValid);
            startActivity(intent);

    }
    public void goQR(View v){
        TextView details = (TextView) findViewById(R.id.tvSDShopname);
        Intent intent = new Intent(this, QrCode.class);
        intent.putExtra("ShopDetails",details.getText().toString());
        startActivity(intent);
    }

    public void buttonOnClick2(View v){
        TextView details = (TextView) findViewById(R.id.tvSDShopname);
        Intent intent = new Intent(this, rateAndReview.class);
        intent.putExtra("ShopDetails",details.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3,menu);
        return true;
    }

    public void buttonOnClick3(View v){
        AlertDialog.Builder a_builder = new AlertDialog.Builder(this);

        a_builder.setMessage("Opening google maps ")
                .setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String uri = "http://maps.google.com/maps?q=loc:" +  globalVariable.detailsLatitude + "," + globalVariable.detailsLongtitude ;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        intent.setData(Uri.parse(uri));
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Choose your path");
        alert.show();
        System.out.println(globalVariable.phoneNumberFromDetails+"meowmeow");
    }

    public void buttonOnClick4(View v){
        AlertDialog.Builder a_builder = new AlertDialog.Builder(this);
        a_builder.setMessage("Opening  Contact Selection ")
                .setCancelable(false).
                setPositiveButton("Phone Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String tempphone = null;
                        tempphone = globalVariable.phoneNumberFromDetails;
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tempphone, null));
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNeutralButton("Message", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String tempphone = null;
                tempphone  = globalVariable.phoneNumberFromDetails;
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.setData(Uri.parse("sms:" + tempphone));
                startActivity(smsIntent);

            }
        });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Choose your path");
        alert.show();
        ;
    }

    public void buttonOnClick5(View v){
        Intent intent = new Intent(this, displayOperation.class);

        startActivity(intent);
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
