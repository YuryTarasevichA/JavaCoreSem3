package org.example;

import java.util.Scanner;

public class Task {

    private Task task;
    private String description;

    public Task(Task task, String description) {
        this.task = task;
        this.description = description;
    }

    public Task(String description) {
        this.description = description;
    }

    public void assignTask(Worker worker) {
        worker.assignTask(task);
        System.out.println("Задача назначена: " + description);
    }

    public String getDescription() {
        return description;
    }
}
