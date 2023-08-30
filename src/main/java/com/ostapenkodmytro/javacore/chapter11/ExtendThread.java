package com.ostapenkodmytro.javacore.chapter11;


class NewThread2 extends Thread {
    NewThread2() {
        super("Демонстрационный поток");
        System.out.println("Дочерний поток: " + this);
    }
    @Override
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        NewThread2 nt = new NewThread2();
        nt.start();
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}