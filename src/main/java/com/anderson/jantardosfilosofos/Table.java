package com.anderson.jantardosfilosofos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pessoa
 */
public class Table extends Thread {

    public List<Fork> forks;
    public List<Philosopher> philosophers;

    public Table() {
        forks = new ArrayList<>();
        philosophers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            forks.add(new Fork());
        }

        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                List<Fork> requiredForks = new ArrayList<>();
                requiredForks.add(forks.get(i));
                requiredForks.add(forks.get(i + 1));
                philosophers.add(new Philosopher(i, requiredForks));
            } else {
                List<Fork> requiredForks = new ArrayList<>();
                requiredForks.add(forks.get(4));
                requiredForks.add(forks.get(0));
                philosophers.add(new Philosopher(i, requiredForks));
            }
        }
    }

    @Override
    public void run() {
        philosophers.forEach(philosopher -> {
            philosopher.start();
        });
    }  
}
