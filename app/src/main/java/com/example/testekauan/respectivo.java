package com.example.testekauan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class respectivo extends AppCompatActivity {
    EditText editarCod, editDescricao, editPreco;
    Button excluir, atualizar;

    DatabaseHelper db;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respectivo);

        db = new DatabaseHelper (this);
        editarCod = (EditText) findViewById(R.id.editCodigo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editPreco = (EditText) findViewById(R.id.editPreco);

        excluir = (Button) findViewById(R.id.excluir);
        atualizar = (Button) findViewById(R.id.atualizar);


        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


            }
        });


        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });

    }



}