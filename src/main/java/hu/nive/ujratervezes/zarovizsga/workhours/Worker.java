package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Worker {

    private String name;
    private int workingHours;
    private LocalDate date;

    public Worker(String name, int workingHours, LocalDate date) {
        this.name = name;
        this.workingHours = workingHours;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public LocalDate getDate() {
        return date;
    }
}
