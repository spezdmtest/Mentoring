package com.ostapenkodmytro.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumFJ extends RecursiveTask<Double> {
    final int seqThresHold = 500;
    double[] data;
    int start, end;

    SumFJ(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if ((end - start) < seqThresHold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            var subTaskA = new SumFJ(data, start, middle);
            var subTaskB = new SumFJ(data, middle, end);
            subTaskA.fork();
            subTaskB.fork();
            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

public class RecurTaskDemo {
    public static void main(String[] args) {
//        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinPool commonFjp = ForkJoinPool.commonPool();
        double[] nums = new double[5000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (((i % 2 == 0) ? i : -i));
        var task = new SumFJ(nums, 0, nums.length);
        var summation = commonFjp.invoke(task);
        System.out.println("Выполненна задача ? - " + task.isCompletedNormally());
        System.out.println("Результат суммирования: " + summation);
        task.reinitialize();
        System.out.println("Результат суммирования после " +
                "переинициализации задачи: " + summation);

    }
}


