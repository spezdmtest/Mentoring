package com.ostapenkodmytro.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThread2(cb, "A");
        new MyThread2(cb, "B");
        new MyThread2(cb, "C");
    }
}

class MyThread2 implements Runnable {
    CyclicBarrier cbar;
    String name;

    MyThread2(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException exc) {
            System.out.println(exc);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}