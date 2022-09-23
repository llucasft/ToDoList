package com.example.todolist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.todolist.R;
import com.example.todolist.helper.ITaskDAO;
import com.example.todolist.helper.TaskDAO;
import com.example.todolist.model.Task;
import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText editTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTask = findViewById(R.id.textTask);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.saveItem:
                TaskDAO taskDAO = new TaskDAO( getApplicationContext() );

                String taskName = editTask.getText().toString();
                if (!taskName.isEmpty()){
                    Task task = new Task();
                    task.setNameTask( taskName );
                    taskDAO.save( task );
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}