package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

import static com.startjava.lesson_2_3_4.calculator.Calculator.calculate;

public class CalculatorTest {

    public static void main(String[] args) {
        String option = "yes";
        Scanner scanner = new Scanner(System.in);

        do {
            if ("yes".equals(option)) {
                System.out.print("Введите математическое выражение: ");
                String mathExpression = scanner.nextLine();
                String[] mathExpParts = mathExpression.split(" ");

                int num1;
                int num2;
                String sign;

                try {
                    sign = mathExpParts[1];
                    num1 = Integer.parseInt(mathExpParts[0]);
                    num2 = Integer.parseInt(mathExpParts[2]);
                    if ((num1 < 1 || num1 > 100) || (num2 < 1 || num2 > 100)) {
                        System.out.println("Числа должны быть от 1 до 100!");
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Формат ввода должен быть: <число1> <операция> <число2>");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("Должны быть целые числа!");
                    continue;
                }

                double result = calculate(num1, sign, num2);
                System.out.print("Результат вычисления: ");
                System.out.printf((result == (int) result ? "%.0f\n" : "%.3f\n"), result);
            }
            System.out.print("Хотите продолжить вычисления? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }
}
