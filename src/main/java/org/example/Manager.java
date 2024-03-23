package org.example;

import java.time.LocalDate;

public class Manager extends Worker{
    public Manager(String name, String firstname, String lastname,
                   String position, String number,
                   int salary, LocalDate birthdata) {
        super(name, firstname, lastname, position,
                number, salary, birthdata);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "lastname='" + getLastname() + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                ", name='" + getName() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", salary=" + getSalary() +
                ", age=" + getAge() +
                "} " + '\n';
    }
    public void takeTask(Task task) {
        this.task = task;
        System.out.println("Задача взята руководителем: " + task.getDescription());
    }

    public void assignTask(Task task, Worker worker) {
        worker.assignTask(task);
        System.out.println("Задача назначена сотруднику " + worker.toString() + ": " + task.getDescription());
    }

}
