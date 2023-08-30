package com.ostapenkodmytro.javacore.chapter11;

class NewThread4 implements Runnable {
    String name;
    Thread t;

    NewThread4(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }

        System.out.println(name + " завершен.");
    }
}

public class DemoJoin {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("Один");
        NewThread4 ob2 = new NewThread4("Два");
        NewThread4 ob3 = new NewThread4("Три");

        System.out.println("Поток один запущен: "
                + ob1.t.isAlive());
        System.out.println("Поток Два запущен: "
                + ob2.t.isAlive());
        System.out.println("Поток Три запущен: "
                + ob3.t.isAlive());
        try {
            System.out.println("Ожидание завершение потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток завершен.");
        }
        System.out.println("Поток Один запущен: "
                + ob1.t.isAlive());
        System.out.println("Поток Два запущен: "
                + ob2.t.isAlive());
        System.out.println("Поток Три запущен: "
                + ob3.t.isAlive());
        System.out.println("Главный поток завершен.");
    }
}