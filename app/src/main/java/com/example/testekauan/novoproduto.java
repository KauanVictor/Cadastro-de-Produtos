package com.example.testekauan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class novoproduto extends AppCompatActivity {

    EditText editCodigo, editDescricao, editPreco;

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DatabaseHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novoproduto);

        openHelper = new DatabaseHelper(this);

        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editPreco = (EditText) findViewById(R.id.editPreco);

        DB = new DatabaseHelper(this);
        openHelper = new DatabaseHelper(this);



        findViewById(R.id.btnnovoproduto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db = DB.getWritableDatabase();
                String cod = editCodigo.getText().toString();
                String desc = editDescricao.getText().toString();
                String preco = editDescricao.getText().toString();

                Boolean insert = DB.insertProduto(cod, desc, preco);

                if (insert == true)
                {
                    Toast.makeText(getApplicationContext(), "Produto cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

}