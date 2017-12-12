package com.example.choonket.fyp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText email , password;
    private Button logbtn,regbtn;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MainPage.class));
            return;
        }

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        logbtn = (Button)findViewById(R.id.logbtn);
        regbtn= (Button)findViewById(R.id.regbtn);

        password.setInputType(InputType.TYPE_CLASS_NUMBER);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait....");

        logbtn.setOnClickListener(this);
        regbtn.setOnClickListener(this);
    }
    private void userLogin(){
        final String userEmail = email.getText().toString().trim();
        final String userPassword = password.getText().toString().trim();
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(obj.getInt("id"),obj.getString("email"));
                                startActivity(new Intent(getApplicationContext(),MainPage.class));
                                finish();
                            }else
                            {
                                Toast.makeText(getApplicationContext(),obj.getString("User Login Failed"), Toast.LENGTH_LONG).show();
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",userEmail);
                params.put("password",userPassword);
                return params;

            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == logbtn){
            userLogin();
        }
        if (v==regbtn){
            startActivity(new Intent(this,Register.class));
        }
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
