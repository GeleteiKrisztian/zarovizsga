package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        List<Worker> workers = readWorkersFromFile(file);
        Worker laziestWorker = null;
        for (Worker item : workers) {
            if (laziestWorker == null || item.getWorkingHours() < laziestWorker.getWorkingHours()) {
                laziestWorker = item;
            }
        }
        if (laziestWorker == null) {
            throw new IllegalArgumentException("Can't find the worker.");
        }
        return laziestWorker.getName() + ": " + laziestWorker.getDate().toString();
    }

    private List<Worker> readWorkersFromFile(String file) {
        List<Worker> workers = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(file));
            for (String line : lines) {
                String[] split = line.split(",");
                String name = split[0];
                int workingHours = Integer.parseInt(split[1]);
                LocalDate date = LocalDate.parse(split[2]);
                Worker worker = new Worker(name, workingHours, date);
                workers.add(worker);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't find the file.", ioe);
        }
        return workers;
    }
}
