package com.example.todolist.helper;

import com.example.todolist.model.Task;

import java.util.List;

public interface ITaskDAO {

    public boolean save(Task task);
    public boolean upgrade(Task task);
    public boolean delete(Task task);
    public List<Task> list();
}
