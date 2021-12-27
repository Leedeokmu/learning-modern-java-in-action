package com.freeefly.ch9;

public class ValidateTest {
    public static void main(String[] args) {
        Validator validator = new Validator(s -> s.matches("[a-z]+"));
        boolean result = validator.validate("abcd");
    }
}
