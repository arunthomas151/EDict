package com.example.arun_thomas.edict;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class Main3Activity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main3);

        setTitle("");

        final ListView lv1 = findViewById(R.id.lv);
        ArrayList<String> arrayDict = new ArrayList<>();
        arrayDict.addAll(Arrays.asList(getResources().getStringArray(R.array.array_dict)));

        adapter = new ArrayAdapter<>(Main3Activity.this, android.R.layout.simple_list_item_1, arrayDict);
        lv1.setAdapter(adapter);


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                String itemValue = (String) lv1.getItemAtPosition(i);
                // Toast.makeText(Main3Activity.this, itemValue , Toast.LENGTH_SHORT).show();
                intent.putExtra("pos",itemValue);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);


    }
}