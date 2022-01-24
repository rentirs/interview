package ru.gb.lesson3.task2;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) counter.increment();
        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) counter.decrement();
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCounter());
    }
}

