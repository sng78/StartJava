package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public static double calculate(int num1, String sign, int num2) {
        return switch (sign) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> (double) num1 / num2;
            case "^" -> Math.pow(num1, num2);
            case "%" -> num1 % num2;
            default -> {
                System.out.println("Недопустимая операция!");
                yield 0;
            }
        };
    }
}
