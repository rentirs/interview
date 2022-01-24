package ru.gb.lesson3.task2;

import java.util.concurrent.locks.ReentrantLock;

public class Counter extends ReentrantLock {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        this.lock();
        counter++;
        this.unlock();
    }

    public void decrement(){
        this.lock();
        counter--;
        this.unlock();
    }
}
