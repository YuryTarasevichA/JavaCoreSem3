package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Worker implements Comparable<Worker> {
    private String name;
    private String firstname;
    private String lastname;
    private String position;
    private String number;
    private int salary;
    private LocalDate birthdata;
    protected Task task;
    protected Worker worker;

    public Worker(String name, String firstname, String lastname, String position, String number, int salary, LocalDate birthdata) {
        this.name = name;
        this.lastname = lastname;
        this.firstname = firstname;
        this.position = position;
        this.number = number;
        this.salary = salary;
        setBirthdata(birthdata);
    }

    public Worker(String name, String firstname, String lastname) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Worker workerSelection(Worker[] workers) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return this.birthdata == null ? -1 : (int) this.birthdata.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public void setBirthdata(LocalDate birthdata) {
        if (birthdata == null || birthdata.isAfter(LocalDate.now().minusYears(14))) {
            System.out.println("Сотрудник не может быть моложе 14 лет");
        } else this.birthdata = birthdata;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + this.getAge() +
                '}' +
                '\n';
    }


    @Override
    public int compareTo(Worker o) {
        return this.getAge() - o.getAge();
    }

    public void assignTask(Task task) {
        this.task = task;
        System.out.println("Задача назначена:  + "  + task.getDescription());
    }

//+ worker.toString() + ":"
}
