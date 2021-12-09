package com.freeefly.ch7;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    private static final long THRESHOLD = 10_000L;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // 분할 sorting 하고 유사
    @Override
    protected Long compute() {
        int length = end - start;
        // 더 이상 분할할 수 없으면 계산 실행
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        // 분할 왼쪽에 해당하는 태스크를 만들어
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        // 다른 쓰레드에 할당
        leftTask.fork();
        // 분할 오른쪽에 해당하는 태스크를 만들어
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
