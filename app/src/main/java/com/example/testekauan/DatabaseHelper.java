package com.example.testekauan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "NOME_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("create Table produtos (codigo TEXT primary key, descricao TEXT, preco INTEGER)");


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


    public Cursor Lista()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + "produtos", null);
        return data;
    }

    public boolean delete(String codigo, String descricao, String preco)
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


}
