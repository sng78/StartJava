package com.startjava.lesson_2_3.calculator;

public class Calculator {
    private int num1;
    private int num2;
    private String sign;

    public Calculator(int num1, String sign, int num2) {
        this.num1 = num1;
        this.sign = sign;
        this.num2 = num2;
    }

    public int calculate() {
        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "^":
                int result = 1;
                for (int i = 0; i < num2; i++) {
                    result *= num1;
                }
                return result;
            case "%":
                return num1 % num2;
            default:
                System.out.println("Недопустимая операция!");
                return 0;
        }
    }
}
