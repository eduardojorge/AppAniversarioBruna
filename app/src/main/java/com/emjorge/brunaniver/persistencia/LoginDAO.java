package com.emjorge.brunaniver.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saba on 10/09/15.
 */
public class LoginDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoLogin";
    private static final int VERSAO = 3;

    public LoginDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Login (id INTEGER PRIMARY KEY,"
                + " login TEXT UNIQUE NOT NULL);";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl ="DROP TABLE IF EXISTS Login";
        db.execSQL(ddl);
        onCreate(db);
    }


    public void salvar(String senha) {
        ContentValues values = new ContentValues();
        values.put("Login", senha);

        getWritableDatabase().insert("Login", null, values);

    }

    public String getSenha(){


        String query = "SELECT  login FROM " + "Login ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        String senha=null;

        if (cursor.moveToFirst()) {
            do {
                senha= cursor.getString(0);

            } while (cursor.moveToNext());
        }
        return senha;
    }

}