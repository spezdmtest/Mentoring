package com.ostapenkodmytro.javacore.Example1_4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class FooDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Foo foo = new Foo();
        CompletableFuture<Void> first = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        CompletableFuture<Void> second = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        CompletableFuture<Void> third = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        first.get();
        second.get();
        third.get();
    }
}

class Foo {
    private final Semaphore semaphore1;
    public Foo() {
        semaphore1 = new Semaphore(1);
        try {
            semaphore1.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    void first(Runnable r) throws InterruptedException {
        print("first");
        semaphore1.release();
    }
    void second(Runnable r) throws InterruptedException {
        semaphore1.acquire();
        print("second");
        semaphore1.release();
    }
    void third(Runnable r) throws InterruptedException {
        semaphore1.acquire();
        print("third");
        semaphore1.release();
    }
    private void print(String str) {
        System.out.print(str);
    }
}
