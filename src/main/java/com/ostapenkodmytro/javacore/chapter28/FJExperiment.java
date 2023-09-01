package com.ostapenkodmytro.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {

    int seqThreshold;
    double[] data;
    int start, end;

    public Transform(double[] vals, int s, int e, int t) {
        this.data = vals;
        this.start = s;
        this.end = e;
        this.seqThreshold = t;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        pLevel = Integer.parseInt("4");
        threshold = Integer.parseInt("1000");

        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);

        beginT = System.nanoTime();
        fjp.invoke(task);
//        fjp.execute(task);
//        while (!task.isDone()) {
//            System.out.println(fjp);
//        }
        endT = System.nanoTime();

        System.out.println("Уровень параллелизма по умолчанию: " + fjp.getParallelism());
        System.out.println("Уровень параллелизма: " + pLevel);
        System.out.println("Колличество процессоров: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Общее затраченное время: " + (endT-beginT) + " нс");
        System.out.println();
    }
}
