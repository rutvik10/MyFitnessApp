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

public class Arms extends AppCompatActivity {
    TextView position;
    ListView listlist;
    EditText editText;
    String[] ListElements = new String[]{"Bicep Curl", "Hammer Curl", "Incline Dumbbell Curl", "Tricep Dips", "Tricep Pushdown"};
    List<String> ListElementsArrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);
        position=findViewById(R.id.position);
        editText=findViewById(R.id.editarms);
        listlist=findViewById(R.id.armslist);

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));


        adapter = new ArrayAdapter<String>
                (Arms.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listlist.setAdapter(adapter);


        Intent i=getIntent();

        int pos=i.getIntExtra("position",3);
        position.setText(String.valueOf(pos));

        listlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Bicepcurl.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Hammercurl.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Inclineddumbbelcurl.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), TricepDips.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Triceppushdown.class));
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
