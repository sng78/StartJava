package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int num1;
    private int num2;
    private String sign;

    public Calculator(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        num1 = Integer.parseInt(elements[0]);
        sign = elements[1];
        num2 = Integer.parseInt(elements[2]);
    }

    public double calculate() {
        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return (double) num1 / num2;
            case "^":
                return Math.pow(num1, num2);
            case "%":
                return num1 % num2;
            default:
                System.out.println("Недопустимая операция!");
                return 0;
        }
    }
}
