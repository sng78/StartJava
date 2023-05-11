package com.startjava.lesson_1.base;

public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int sumEven = 0;
        int sumOdd = 0;
        int counter = -10;
        do {
            if (counter % 2 == 0) {
                sumEven += counter;
            } else {
                sumOdd += counter;
            }
            counter++;
        } while (counter <= 21);
        System.out.printf("В промежутке [-10, 21] сумма четных чисел = %d, а нечетных = %d\n",
                sumEven, sumOdd);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int min = num2;
        int max = num2;
        if (num1 < num2) {
            min = num1;
        }
        if (min > num3) {
            min = num3;
        }
        if (num1 > num2) {
            max = num1;
        }
        if (max < num3) {
            max = num3;
        }
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        num1 = 1234;
        int sum = 0;
        System.out.print("Исходное число в обратном порядке: ");
        while (num1 > 0) {
            int lastDigit = num1 % 10;
            num1 /= 10;
            sum += lastDigit;
            System.out.print(lastDigit);
        }
        System.out.println("\nСумма его цифр: " + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк");
        int count = 0;
        for (int i = 1; i < 31; i += 2) {
            System.out.printf("%2d ", i);
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
        if (count != 0) {
            for (int i = 0; i < (5 - count); i++) {
                System.out.printf("%2d ", 0);
            }
            System.out.println();
        }

        System.out.println("\n5. Проверка количества двоек на четность / нечетность");
        num1 = 3242592;
        int copyNum1 = num1;
        int countTwos = 0;
        while (copyNum1 > 0) {
            if (copyNum1 % 10 == 2) {
                countTwos++;
            }
            copyNum1 /= 10;
        }
        System.out.printf("Число %d содержит %d(", num1, countTwos);
        if (countTwos % 2 == 0) {
            System.out.print("четное");
        } else {
            System.out.print("нечетное");
        }
        System.out.println(") количество двоек");

        System.out.println("\n6. Отображение фигур в консоли");
        //прямоугольник
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        //прямоугольный треугольник
        int height = 5;
        while (height > 0) {
            int symbols = height;
            while (symbols > 0) {
                System.out.print("#");
                symbols--;
            }
            System.out.println();
            height--;
        }
        System.out.println();

        //равнобедренный треугольник
        height = 5;
        int width = 0;
        do {
            if (height > 2) {
                width++;
            } else {
                width--;
            }
            int symbols = width;
            do {
                System.out.print("$");
                symbols--;
            } while (symbols > 0);
            System.out.println();
            height--;
        } while (height > 0);

        System.out.println("\n7. Отображение ASCII-символов");
        System.out.println("\tСимволы, идущие до цифр и имеющие нечетные коды:");
        for (int i = 0; i < 48; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d %c\n", i, (char) i);
            }
        }
        System.out.println("\tМаленькие английские буквы, имеющие четные коды:");
        for (int i = 97; i < 123; i++) {
            if (i % 2 == 0) {
                System.out.printf("%3d %c\n", i, (char) i);
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        num1 = 12321;
        copyNum1 = num1;
        int reverse = 0;
        while (copyNum1 > 0) {
            int lastDigit = copyNum1 % 10;
            reverse = reverse * 10 + lastDigit;
            copyNum1 /= 10;
        }
        if (num1 == reverse) {
            System.out.printf("Число %d является палиндромом\n", num1);
        } else {
            System.out.printf("Число %d не является палиндромом\n", num1);
        }

        System.out.println("\n9. Определение, является ли число счастливым");
        num1 = 231123;
        int firstHalfNum1 = num1 % 1000;
        int secondHalfNum1 = num1 / 1000;
        int firstHalfSumNum1 = 0;
        int secondHalfSumNum1 = 0;
        int firstHalfCopy = firstHalfNum1;
        int secondHalfCopy = secondHalfNum1;
        while (firstHalfCopy > 0) {
            firstHalfSumNum1 += firstHalfCopy % 10;
            secondHalfSumNum1 += secondHalfCopy % 10;
            firstHalfCopy /= 10;
            secondHalfCopy /= 10;
        }
        System.out.printf("Сумма цифр %d = %d\n", firstHalfNum1, firstHalfSumNum1);
        System.out.printf("Сумма цифр %d = %d\n", secondHalfNum1, secondHalfSumNum1);
        if (firstHalfSumNum1 == secondHalfSumNum1) {
            System.out.printf("Число %d является счастливым\n", num1);
        } else {
            System.out.printf("Число %d не является счастливым\n", num1);
        }

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        System.out.println("     ТАБЛИЦА ПИФАГОРА");
        System.out.println("  |  2  3  4  5  6  7  8  9");
        System.out.println("--+------------------------");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%d | ", i);
            for (int j = 2; j < 10; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }
    }
}
