package com.example.myfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercisecategories extends AppCompatActivity {

    ListView listView;
    String[] ListElements = new String[]{"Chest", "Shoulder", "Legs", "Arms", "Back"};
    List<String> ListElementsArrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisecategories);
        listView = findViewById(R.id.listView1);

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>
                (Exercisecategories.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Rutvik","Position-> " + position);
                Log.i("Rutvik","Names-> " + ListElements[position]);
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Chest.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Shoulder.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Legs.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Arms.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Back.class));
                        break;
                }
            }
        });
    }




    }