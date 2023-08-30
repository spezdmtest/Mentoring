package com.ostapenkodmytro.javacore.chapter11;

class NewThreadNew implements Runnable {
    Thread t;

    public NewThreadNew() {
        t = new Thread(this, "Демострационный поток");
        System.out.println("Дочерний поток создан: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }

    public static NewThreadNew createAndStart() {
        NewThreadNew myThrd = new NewThreadNew();
        myThrd.t.start();
        return myThrd;
    }

}

public class ThreadDemoNew {
    public static void main(String[] args) {
        NewThreadNew.createAndStart();
    }
}
