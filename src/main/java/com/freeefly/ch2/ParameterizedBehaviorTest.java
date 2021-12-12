package com.freeefly.ch2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ParameterizedBehaviorTest {
    public static void main(String[] args) {
        System.out.println("ParameterizedBehaviorTest");
        ParameterizedBehaviorTest.testFilter("p", (p) -> p.equals("p"));

    }

    private static boolean testFilter(String target, Predicate<String> filter) {
        if (filter.test(target)) {
            return true;
        }
        return false;

    }
}
