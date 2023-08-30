package com.ostapenkodmytro.javacore.chapter11;

import javax.xml.transform.TransformerException;

class Q {
    int n;

    synchronized int get() {
        System.out.println("Полученко: " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Отправлено: " + n);
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Поставщик");
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Потребитель");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        producer.t.start();
        consumer.t.start();

        System.out.println("Нажмите <Ctrl-C>, чтобы остановить прогамму.");
    }
}