package com.example.todolist.model;

import java.io.Serializable;

public class Task implements Serializable {

    private long id;
    private String nameTask;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
}
