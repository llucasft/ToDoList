package com.example.todolist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolist.model.Task;

import java.util.ArrayList;
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
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Task task) {

        ContentValues cv = new ContentValues();
        cv.put("name", task.getNameTask());

        try{
            String[] args = {String.valueOf(task.getId())};
            writer.update(DbHelper.TASKS_TABLE, cv, "id=?", args);
            Log.i("INFO","Task updated successfully " );
        }catch (Exception e){
            Log.i("INFO","Error updating task " + e.getMessage() );
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Task task) {

        try{
            String[] args = {String.valueOf(task.getId())};
            writer.delete(DbHelper.TASKS_TABLE, "id=?", args);
            Log.i("INFO","Task deleted successfully " );
        }catch (Exception e){
            Log.i("INFO","Error deleting task " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public List<Task> list() {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TASKS_TABLE + " ;";
        Cursor c = reader.rawQuery(sql, null);

        while (c.moveToNext()){

            Task task = new Task();

            int columnIndex = c.getColumnIndex("id");
            int columnNameIndex = c.getColumnIndex("name");

            Long id = c.getLong(columnIndex);
            String taskName = c.getString( columnNameIndex );

            task.setId( id );
            task.setNameTask( taskName );

            tasks.add(task);
        }

        return tasks;
    }
}
