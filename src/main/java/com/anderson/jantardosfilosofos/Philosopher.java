package com.anderson.jantardosfilosofos;

import java.util.List;

/**
 *
 * @author Pessoa
 */
public class Philosopher extends Thread {

    public int identification;
    public List<Fork> requiredForks;

    public Philosopher(int identification, List<Fork> requiredForks) {
        super("Philosopher " + identification);
        this.identification = identification;
        this.requiredForks = requiredForks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (requiredForks.stream().allMatch(d -> d.hasQueuedThreads())) {
                    System.out.println("Philosopher #" + identification + " can't eat now.");
                    return;
                }
                for (Fork requiredFork : requiredForks) {
                    requiredFork.acquire();
                }

                System.out.println("Philosopher #" + identification + " is eating.");

                Thread.sleep(2000);
            } catch (InterruptedException e) {

            } finally {
                requiredForks.forEach(d -> d.release());
                System.out.println("Philosopher #" + identification + " is thinking again.");
            }
        }

    }
}
