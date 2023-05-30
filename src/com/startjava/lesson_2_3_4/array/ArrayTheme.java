package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        reverseElements();
        multiplicationElements();
        deleteElements();
        stairsBackElements();
        uniqueNumbers();
        notEmptyStrings();
    }

    public static void reverseElements() {
        System.out.println("\n\t1. Реверс значений массива");
        int[] intArr = {1, 3, 7, 4, 2, 6, 5};
        System.out.print("Массив до модификации: ");
        printIntArr(intArr);
        for (int i = 0; i < intArr.length / 2; i++) {
            int start = 0;
            int end = intArr.length - 1;
            while (start < end) {
                int temp = intArr[start];
                intArr[start] = intArr[end];
                intArr[end] = temp;
                start++;
                end--;
            }
        }
        System.out.print("Массив после модификации: ");
        printIntArr(intArr);
    }

    public static void multiplicationElements() {
        System.out.println("\n\t2. Вывод произведения элементов массива");
        int[] intArr = new int[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i;
        }
        int multiInts = 1;
        for (int i = 1; i < intArr.length - 1; i++) {
            multiInts *= intArr[i];
            System.out.print(intArr[i] < intArr.length - 2 ? intArr[i] + " * " : intArr[i]);
        }
        System.out.println(" = " + multiInts);
        System.out.printf("[%d] = %d; [%d] = %d\n", 0, intArr[0], intArr.length, intArr[intArr.length - 1]);
    }

    public static void deleteElements() {
        System.out.println("\n\t3. Удаление элементов массива");
        double[] doubleArr = new double[15];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = Math.random();
        }
        System.out.println("Исходный массив:");
        printDoubleArr(doubleArr);
        int avgIndex = doubleArr.length / 2;
        double numFromAvgIndex = doubleArr[avgIndex];
        int zeroCells = 0;
        for (int i = 0; i < doubleArr.length; i++) {
            if (numFromAvgIndex < doubleArr[i]) {
                doubleArr[i] = 0;
                zeroCells++;
            }
        }
        System.out.println("Измененный массив:");
        printDoubleArr(doubleArr);
        System.out.println("Обнуленных ячеек: " + zeroCells);
    }

    public static void stairsBackElements() {
        System.out.println("\n\t4. Вывод элементов массива лесенкой в обратном порядке");
        char[] alphabetArr = new char[26];
        int i = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++, i++) {
            alphabetArr[i] = ch;
        }
        for (int j = alphabetArr.length - 1; j >= 0; j--) {
            for (int k = alphabetArr.length - 1; k >= j; k--) {
                System.out.print(alphabetArr[k]);
            }
            System.out.println();
        }
    }

    public static void uniqueNumbers() {
        System.out.println("\n\t5. Генерация уникальных чисел");
        int[] intArr = new int[30];
        for (int i = 0; i < intArr.length; i++) {
            while (true) {
                boolean isNotUnique = false;
                int randomNum = (int) (Math.random() * 40 + 60);
                for (int j = 0; j < i; j++) {
                    if (randomNum == intArr[j]) {
                        isNotUnique = true;
                        break;
                    }
                }
                if (!isNotUnique) {
                    intArr[i] = randomNum;
                    break;
                }
            }
        }
        Arrays.sort(intArr);
        int count = 0;
        for (int num : intArr) {
            System.out.print(num + " ");
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }

    public static void notEmptyStrings() {
        System.out.println("\n\t6. Копирование не пустых строк");
        String[] stringArr = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        int count = 0;
        for (String str : stringArr) {
            if (!str.isBlank()) {
                count++;
            }
        }
        String[] notEmptyStringArr = new String[count];
        int srcPos = -1;
        int destPos = 0;
        for (int i = 0; i < stringArr.length; i++) {
            if (!stringArr[i].isBlank()) {
                if (srcPos == -1) {
                    if (stringArr[i + 1].isBlank()) {
                        System.arraycopy(stringArr, i, notEmptyStringArr, destPos, 1);
                        destPos++;
                    } else {
                        srcPos = i;
                    }
                } else {
                    if (stringArr[i + 1].isBlank()) {
                        System.arraycopy(stringArr, srcPos, notEmptyStringArr, destPos, i - srcPos + 1);
                        destPos += i - srcPos + 1;
                        srcPos = -1;
                    }
                }
            }
        }
        System.out.println("Исходный массив " + Arrays.toString(stringArr));
        System.out.println("Массив без пустых строк " + Arrays.toString(notEmptyStringArr));
    }

    private static void printIntArr(int[] intArr) {
        for (int num : intArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void printDoubleArr(double[] doubleArr) {
        int count = 0;
        for (double num : doubleArr) {
            System.out.printf("%05.3f   ", num);
            count++;
            if (count == 8) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }
}
