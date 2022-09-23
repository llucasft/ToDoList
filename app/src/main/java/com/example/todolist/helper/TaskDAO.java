package com.example.todolist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolist.model.Task;

import java.util.List;

public class TaskDAO implements ITaskDAO{

    private SQLiteDatabase writer;
    private SQLiteDatabase reader;

    public TaskDAO(Context context) {

        DbHelper db = new DbHelper(context);
        writer = db.getWritableDatabase();
        reader = db.getReadableDatabase();

    }

    @Override
    public boolean save(Task task) {

        ContentValues cv = new ContentValues();
        cv.put("name", task.getNameTask());

        try{
            writer.insert(DbHelper.TASKS_TABLE, null, cv);
            Log.i("INFO","Task saved successfully " );
        }catch (Exception e){
            Log.i("INFO","Error saving task " + e.getMessage() );
        }

        return true;
    }

    @Override
    public boolean upgrade(Task task) {
        return false;
    }

    @Override
    public boolean delete(Task task) {
        return false;
    }

    @Override
    public List<Task> list() {
        return null;
    }
}