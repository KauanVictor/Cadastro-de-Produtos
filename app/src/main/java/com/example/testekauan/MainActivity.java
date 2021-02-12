package com.example.testekauan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    ArrayList<String> lista;
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        lv = (ListView)findViewById(R.id.lista);
        DatabaseHelper DB = new DatabaseHelper(this);
        lista = DB.visualizar();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);


        findViewById(R.id.cadastrarproduto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), novoproduto.class);
                startActivity(intent);
            }
        });
    }


}