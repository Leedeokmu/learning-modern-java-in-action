package com.freeefly.ch7;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ParallelTest {

    public static void main(String[] args) {


    }

    private long parallelRangedSum() {
        long N = Long.MAX_VALUE;
        return LongStream.rangeClosed(0, N)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
