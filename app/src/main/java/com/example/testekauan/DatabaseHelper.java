package com.example.testekauan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {





    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "NOME_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("create Table produtos (codigo TEXT primary key, descricao TEXT, preco TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {        sqLiteDatabase.execSQL("drop Table if exists produtos");

    }

    public boolean insertProduto(String codigo, String descricao, String preco)
    {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Codigo", codigo);
        contentValues.put("Descricao", descricao);
        contentValues.put("Preco", preco);



        long result  = MyDB.insert("produtos", null, contentValues);
        if (result == -1)  return false;

        else
            return true;
    }

    public ArrayList visualizar()
    {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String s = "SELECT * FROM produtos";

        Cursor cursor = database.rawQuery(s, null);
        if (cursor.moveToFirst())
        {
            do {
                lista.add(cursor.getString(0));
            }

            while (cursor.moveToNext());
        }
        return lista;
    }




}
