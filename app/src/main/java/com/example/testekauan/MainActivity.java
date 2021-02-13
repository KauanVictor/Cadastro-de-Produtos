package com.example.testekauan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    DatabaseHelper MEUDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         lv = (ListView)findViewById(R.id.lista);
         MEUDB = new DatabaseHelper(this);
         ArrayList<String> list = new ArrayList<>();
         Cursor data = MEUDB.Lista();

         if (data.getCount() == 0)
         {
             Toast.makeText(this, "Nenhum produto cadastrado.", Toast.LENGTH_SHORT).show();
         }

         else {
             while (data.moveToNext())
             {
                 list.add(data.getString(1));
                 ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
                 lv.setAdapter(listAdapter);
             }
         }


         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getApplicationContext(), respectivo.class);
                    startActivity(intent);


             }
         });




        findViewById(R.id.cadastrarproduto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), novoproduto.class);
                startActivity(intent);
            }
        });
    }

    private void confirmaExclusao()
    {
        AlertDialog.Builder exclusao = new AlertDialog.Builder(getApplicationContext());
        exclusao.setTitle("Confirmar exclusão.");
        exclusao.setMessage("Você realmente deseja excluir este registro?");
        exclusao.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                excluir();

            }
        });

        exclusao.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        exclusao.show();
    }

    private void excluir()
    {


    }

}