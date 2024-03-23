package org.example;

import java.util.Comparator;

public class WorkerLastNameComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
