package com.example.myfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Legs extends AppCompatActivity {
    TextView position;
    ListView listlist;
    EditText editText;
    String[] ListElements = new String[]{"Leg Press", "Squats", "Step Up", "Walking Lunges", "Romanian Deadlift"};
    List<String> ListElementsArrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        position=findViewById(R.id.position);
        editText=findViewById(R.id.editlegs);
        listlist=findViewById(R.id.legslist);

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));


        adapter = new ArrayAdapter<String>
                (Legs.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listlist.setAdapter(adapter);


        Intent i=getIntent();

        int pos=i.getIntExtra("position",2);
        position.setText(String.valueOf(pos));

        listlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Legpress.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Squats.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Stepup.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Walkinglunges.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), RomanianDeadlift.class));
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add:
                ListElementsArrayList.add(editText.getText().toString());

                adapter.notifyDataSetChanged();

                editText.getText().clear();
        }

        return super.onOptionsItemSelected(item);
    }
}
