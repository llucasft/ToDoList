package com.example.todolist.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DB_NAME = "DB_TASKS";
    public static String TASKS_TABLE = "tasks";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TASKS_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" name TEXT NOT NULL ) ;";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "SUCESSO AO CRIAR TABELA ");
        } catch (Exception e){
            Log.i("INFO DB", "ERRO AO CRIAR TABELA " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS " + TASKS_TABLE + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "SUCESSO AO APAGAR TABELA ");
        } catch (Exception e){
            Log.i("INFO DB", "ERRO AO APAGAR TABELA " + e.getMessage());
        }
    }
}
