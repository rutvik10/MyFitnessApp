package com.example.myfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Profile extends AppCompatActivity {
    TextView name, email, height, weight, bmiid;
    SharedPreferences sp;
    Intent intent;
    Button exercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bmiid = findViewById(R.id.bmiid);
        exercise=findViewById(R.id.exercise);


        Intent i = getIntent();


        String nameid = i.getStringExtra("name");
        String emailid = i.getStringExtra("email");
        String heightid = i.getStringExtra("height");
        String weightid = i.getStringExtra("weight");


        name.setText(nameid);
        email.setText(emailid);
        height.setText(heightid);
        weight.setText(weightid);


        sp = getSharedPreferences("user_details", MODE_PRIVATE);
        intent = new Intent(Profile.this, Register.class);

        bmi();

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Profile.this,Exercisecategories.class);
                startActivity(i);
            }
        });
    }

    private void bmi() {
        float a, b, c;
        a = Float.parseFloat(height.getText().toString()) / 100;
        b = Float.parseFloat(weight.getText().toString());
        c = b / (a * a);
        bmiid.setText("" + c);


    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        new AlertDialog.Builder(Profile.this)
                .setTitle("Warning")
                .setMessage("Do you want to close app")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Intent.ACTION_MAIN);
                        i.addCategory(Intent.CATEGORY_HOME);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);

                    }
                })
                .setNegativeButton("NO", null)
                .show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.logout:
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(Profile.this, Login.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}