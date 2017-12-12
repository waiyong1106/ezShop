package com.example.choonket.fyp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class Register extends AppCompatActivity {
    private EditText et_name, et_dob, et_phone, et_address, et_ic, et_email, et_password, et_cpassword;
    private String ic, name, address, dob, email, phone, password, cpassword;
    private ProgressDialog progressDialog;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name = (EditText) findViewById(R.id.name);
        et_address = (EditText) findViewById(R.id.address);
        et_dob = (EditText) findViewById(R.id.dob);
        et_phone = (EditText) findViewById(R.id.phone);
        et_ic = (EditText) findViewById(R.id.ic);
        et_email = (EditText) findViewById(R.id.email);
        et_password = (EditText) findViewById(R.id.password);
        et_cpassword = (EditText) findViewById(R.id.cpassword);
        regbtn=(Button)findViewById(R.id.regbtn) ;
        progressDialog = new ProgressDialog(this);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    public void register() {
        intialize();
        if (!validate()){
            Toast.makeText(this,"Signup has Failed",Toast.LENGTH_SHORT).show();
        }
        else
            success();
    }
    public void success(){
        progressDialog.setMessage("Registering User....");
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException exception) {
                            exception.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("dob",dob);
                params.put("phone",phone);
                params.put("address",address);
                params.put("ic",ic);
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
    public boolean validate(){
        boolean valid = true;
        if(name.isEmpty()){
            et_name.setError("Please Enter Name");
            valid = false;
        }
        if(dob.isEmpty()){
            et_dob.setError("Please Enter Date Of Birth");
            valid = false;
        }
        if(phone.isEmpty()){
            et_phone.setError("Please Enter Phone Nombor");
            valid = false;
        }
        if(address.isEmpty()){
            et_address.setError("Please Enter Address");
            valid = false;
        }
        if(ic.isEmpty()){
            et_ic.setError("Please Enter Identity Card Nombor");
            valid = false;
        }
        if(email.isEmpty()){
            et_email.setError("Please Enter Email");
            valid = false;
        }
        if (password.isEmpty()){
            et_password.setError("Please Enter Password");
            valid = false;
        }
        if (cpassword.isEmpty()){
            et_cpassword.setError("Please Enter Confirm Password");
            valid = false;
        }
        if(password != cpassword){
            et_cpassword.setError("Password Not Match");
            valid = false;
        }
        return valid;
    }

    public void intialize() {
        name = et_name.getText().toString().trim();
        address = et_address.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        dob = et_dob.getText().toString().trim();
        ic = et_ic.getText().toString().trim();
        email = et_email.getText().toString().trim();
        password = et_password.getText().toString().trim();
        cpassword = et_cpassword.getText().toString().trim();
    }
}
