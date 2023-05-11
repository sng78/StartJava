package com.startjava.lesson_1.base;

public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("\n\t1. Вывод характеристик компьютера");
        byte cores = 12;
        short ssd = 2;
        int freq = 3300;
        long mem = 16777216L;
        float weight = 3.15F;
        double ver = 22000.1817;
        char model = 'A';
        boolean isPortable = true;
        System.out.println("Модель компьютера - " + model);
        System.out.println("Ноутбук - " + isPortable);
        System.out.println("Количество ядер процессора - " + cores);
        System.out.println("Частота процессора, Гц - " + freq);
        System.out.println("Объем памяти, байт - " + mem);
        System.out.println("Количество жестких дисков - " + ssd);
        System.out.println("Номер сборки Windows - " + ver);
        System.out.println("Масса, г - " + weight);

        System.out.println("\n\t2. Расчет стоимости товара со скидкой");
        int penPrice = 100;
        int bookPrice = 200;
        int cost = penPrice + bookPrice;
        double discount = cost * 0.11;
        System.out.println("Общая стоимость товаров без скидки - " + cost);
        System.out.println("Сумма скидки - " + discount);
        System.out.println("Общая стоимость товаров со скидкой - " + (cost - discount));

        System.out.println("\n\t3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n\t4. Вывод min и max значений целых числовых типов");
        byte maxByte = 127;
        short maxShort = 32767;
        int maxInt = 2147483647;
        long maxLong = 9223372036854775807L;
        System.out.println(maxByte + " " + ++maxByte + " " + --maxByte);
        System.out.println(maxShort + " " + ++maxShort + " " + --maxShort);
        System.out.println(maxInt + " " + ++maxInt + " " + --maxInt);
        System.out.println(maxLong + " " + ++maxLong + " " + --maxLong);

        System.out.println("\n\t5. Перестановка значений переменных");
        int num1 = 2;
        int num2 = 5;
        System.out.println("\tС помощью третьей переменной");
        System.out.println("Исходные значения - " + num1 + " и " + num2);
        int num = num1;
        num1 = num2;
        num2 = num;
        System.out.println("Новые значения - " + num1 + " и " + num2);
        System.out.println("\tС помощью арифметических операций");
        System.out.println("Исходные значения - " + num1 + " и " + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println("Новые значения - " + num1 + " и " + num2);
        System.out.println("\tС помощью побитовой операции");
        System.out.println("Исходные значения - " + num1 + " и " + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println("Новые значения - " + num1 + " и " + num2);

        System.out.println("\n\t6. Вывод символов и их кодов");
        char numberSign = '#';
        char ampersand = '&';
        char at = '@';
        char caret = '^';
        char under = '_';
        System.out.println(numberSign + " " + (int) numberSign);
        System.out.println(ampersand + " " + (int) ampersand);
        System.out.println(at + " " + (int) at);
        System.out.println(caret + " " + (int) caret);
        System.out.println(under + " " + (int) under);

        System.out.println("\n\t7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backslash = '\\';
        char leftBr = '(';
        char rightBr = ')';
        System.out.printf("%5c%c\n", slash, backslash);
        System.out.printf("%4c%3c\n", slash, backslash);
        System.out.printf("%3c%c%c%2c%c\n", slash, under, leftBr, rightBr, backslash);
        System.out.printf("%2c%7c\n", slash, backslash);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c\n", slash, under, under, under, under, slash,
                backslash, under, under, backslash);

        System.out.println("\n\t8. Вывод количества сотен, десятков и единиц числа");
        num = 123;
        int hundreds = num / 100;
        int tens = num / 10 % 10;
        int ones = num % 10;
        System.out.printf("Число %d содержит:\n", num);
        System.out.printf("\t%d сотен\n", hundreds);
        System.out.printf("\t%d десятков\n", tens);
        System.out.printf("\t%d единиц\n", ones);
        System.out.printf("Сумма его цифр = %d\n", (hundreds + tens + ones));
        System.out.printf("Произведение = %d\n", (hundreds * tens * ones));

        System.out.println("\n\t9. Вывод времени");
        int time = 86399;
        int hr = time / 3600;
        int min = time / 60 % 60;
        int sec = time % 60;
        System.out.printf("%d:%d:%d\n", hr, min, sec);
    }
}
