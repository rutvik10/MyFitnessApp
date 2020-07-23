package com.example.myfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Register extends AppCompatActivity {
    EditText name, email, password, retype, weight, height;
    Button register;
    Intent intent;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        retype = findViewById(R.id.et_repassword);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        register = findViewById(R.id.btn_register);


        sp = getSharedPreferences("user_details", MODE_PRIVATE);
        intent = new Intent(Register.this, Profile.class);

        if (sp.contains("email") && sp.contains("name") && sp.contains("weight") && sp.contains("height")) {
            intent.putExtra("email", sp.getString("email", ""));
            intent.putExtra("name", sp.getString("name", ""));
            intent.putExtra("height", sp.getString("height", ""));
            intent.putExtra("weight", sp.getString("weight", ""));
            startActivity(intent);
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameid = name.getText().toString().trim();
                String emailid = email.getText().toString().trim();
                String passid = password.getText().toString().trim();
                String retypeid = retype.getText().toString().trim();
                String heightid = height.getText().toString().trim();
                String weightid = weight.getText().toString().trim();



                if (emailid.equals(""))
                    email.setError("Please enter email id");
                if (passid.equals(""))
                    password.setError("Please enter password");
                if (nameid.equals(""))
                    name.setError("Please Enter Name");
                if (retypeid.equals(""))
                    retype.setError("Please Retype Password");
                if (!retypeid.equals(passid)) {
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                }
                if (heightid.equals(""))
                    height.setError("Please enter Height");
                if (weightid.equals(""))
                    weight.setError("Please Enter Weight");

                else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches())
                    email.setError("Invalid Email id");



                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", emailid);
                editor.putString("name", nameid);
                editor.putString("weight", weightid);
                editor.putString("height", heightid);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

                intent.putExtra("name", nameid);
                intent.putExtra("email", emailid);
                intent.putExtra("height", heightid);
                intent.putExtra("weight", weightid);


                startActivity(intent);


            }

        });

    }
}
