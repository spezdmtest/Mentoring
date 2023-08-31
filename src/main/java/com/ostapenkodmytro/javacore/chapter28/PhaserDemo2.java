package com.ostapenkodmytro.javacore.chapter28;


import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhaser;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhaser = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int p, int regParties) {
        System.out.println("Фаза " + p + " завершена.\n");

        return p == numPhaser || regParties == 0;
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {

        MyPhaser phsr = new MyPhaser(1, 4);

        System.out.println("Запуск потоков\n");

        new MyThread4(phsr, "A");
        new MyThread4(phsr, "B");
        new MyThread4(phsr, "C");

        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }

        System.out.println("Синхронизатор фаз завершен");
    }
}

class MyThread4 implements Runnable {
    Phaser phsr;
    String name;

    MyThread4(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println(
                    "Поток " + name + " начинает фазу " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}