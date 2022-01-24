package ru.gb.lesson3.task1;

public class Main {
    public static void main(String[] args) {

        Thread first = new Thread(() -> play(PingPong.PING));

        Thread second = new Thread(() -> play(PingPong.PONG));

        while (true) {
            first.run();
            second.run();
        }
    }

    public static synchronized void play(PingPong pingPong) {
        System.out.println(pingPong);
    }
}
