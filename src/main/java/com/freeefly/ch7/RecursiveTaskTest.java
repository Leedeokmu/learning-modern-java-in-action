package com.freeefly.ch7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class RecursiveTaskTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long number = 10_000_000_000L;
        System.out.printf("sum: %s\n", sum(number));
//        System.out.printf("sum: %s\n", forkJoinSum(number));
        long end = System.currentTimeMillis();
        System.out.printf("took: %s", (end - start));

    }
    private static long sum(long number) {
        long result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }

    private static long forkJoinSum(long number) {
        long[] numbers = LongStream.rangeClosed(1, number).toArray();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(forkJoinTask);
    }
}
