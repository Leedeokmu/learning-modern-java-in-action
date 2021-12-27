package com.freeefly.ch9;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        int h1 = 10;
        Runnable r2 = () -> {
            System.out.println("Hello");
        };
    }
}
