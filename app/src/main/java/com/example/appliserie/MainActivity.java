package com.example.appliserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Serie> lesSeries = new ArrayList<Serie>();
    ListView lstView;
    SerieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONHelper listeSerieJson = new JSONHelper(MainActivity.this);
        lesSeries = listeSerieJson.getLesSeries();
        lstView = findViewById(R.id.lstView);
        mAdapter = new SerieAdapter(MainActivity.this,lesSeries);
        lstView.setAdapter(mAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailSerieActivity = new Intent(MainActivity.this, DetailSerie.class);
                detailSerieActivity.putExtra("pos",position);
                startActivity(detailSerieActivity);

            }
        });

    }
}