package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        String option = "yes";
        Scanner scanner = new Scanner(System.in);

        do {
            if ("yes".equals(option)) {
                System.out.print("Введите математическое выражение: ");
                String mathExpression = scanner.nextLine();
                Calculator calculator = new Calculator(mathExpression);
                double result = calculator.calculate();
                System.out.print("Результат вычисления: ");
                System.out.printf((result == (int) result ? "%.0f\n" : "%.3f\n"), result);
            }
            System.out.print("Хотите продолжить игру? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }
}
