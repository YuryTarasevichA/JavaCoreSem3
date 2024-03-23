package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Worker[] workers = {
                new Worker("Ivan", "Ivanovich", "Ivanov",
                        "engineer", "+375-29-321-12-43",
                        1500, LocalDate.of(2000, 12, 15)),
                new Worker("Yury", "Yurovich", "Yurkin",
                        "programer (beck-end)", "+375-29-567-42-45",
                        1600, LocalDate.of(1989, 12, 15)),
                new Worker("Tolik", "Andreevich", "Potapov",
                        "programer (front-end)", "+375-29-897-66-32",
                        1600, LocalDate.of(1990, 3, 7)),
                new Manager("Masha", "Mihailovna", "Mirkina",
                        "manager", "+375-25-567-54-45",
                        3000, LocalDate.of(1996, 4, 29))
        };
        System.out.println("Average age: " + getAverageAge(workers));
        System.out.println("Average salary: " + getAverageSalary(workers));
        System.out.println(Arrays.toString(workers));
        List<Worker> workerList = Arrays.asList(workers);
        System.out.println("-----------".repeat(10));

        addSalary(workers, 25, (int) (workers[0].getSalary() * 0.20));
        System.out.println("Average salary: " + getAverageSalary(workers));
        addSalary(workers, 30, (int) (workers[0].getSalary() * 0.10));
        System.out.println("Average salary: " + getAverageSalary(workers));
        System.out.println("-----------".repeat(10));

        workerList.sort(new WorkerSalaryComparator());
        System.out.println("Отсортирован список по зарплате: ");
        System.out.println(workerList);
        System.out.println("-----------".repeat(10));
//        workerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
//        System.out.println(workerList);

        workerList.sort(new WorkerLastNameComparator());
        System.out.println("Отсортирован по имени: ");
        System.out.println(workerList);

// Реализация 3 задачи домашнего задания (давать задачи сотрудникам)

        System.out.println("-----------".repeat(10));
        workers[0].assignTask(new Task("решить задачу 1"));
        Manager manager = (Manager) getManager(workers);
        manager.assignTask(new Task("решить задачу 2"), workers[1]);
        manager.takeTask(new Task("решить сложную задачу"));
//        Scanner scanner = new Scanner(System.in);
//        try {
//            Worker selectedWorker = Worker.workerSelection(workers);
//            selectedWorker = workerSelection(workers, selectedWorker);
//            if (selectedWorker != null) {
//                System.out.println("Выбранный сотрудник: " + selectedWorker.toString());
//                System.out.println("Даём задачу сотруднику");
//                String discription = scanner.nextLine();
//                Task task = new Task(discription);
//                System.out.println();
//            } else {
//                System.out.println("Не удалось выбрать сотрудника.");
//            }
//        } catch (NullPointerException e) {
//            System.out.println("Произошла ошибка: " + e.getMessage());
//        }

//        System.out.println("Менеджер даёт задачу сотруднику");
//        manager.assignTask(new Task(), selectedWorker);
//        System.out.println("Менеджер даёт себе задачу сам");
//        manager.takeTask(new Task());


    }
    public static Worker workerSelection(Worker[] array, Worker selectedWorker) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите сотрудника, которому хотите вручить задачу: ");
        for (Worker worker : array) {
            System.out.println(worker.toString());
        }
        String selectedWorkerName = scanner.nextLine();
        for (Worker worker : array) {
            if (worker.getName().equals(selectedWorkerName) || worker.getLastname().equals(selectedWorkerName) ||
                    worker.getFirstname().equals(selectedWorkerName)) {
                selectedWorker = worker;
            }
        }return selectedWorker;
    }
    public static Worker getManager(Worker[] array){
        Worker manager = null;
        for (Worker worker : array) {
            if (worker instanceof Manager) {
                manager = (Manager) worker;
                break;
            }
        }return manager;
    }


    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }

    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if (!(worker instanceof Manager)) {
                if (worker.getAge() >= age) {
                    worker.setSalary(worker.getSalary() + addAmount);
                }
            }
        }
        System.out.println("Зарплата повышена успешно!");
    }
}