package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        reverseElements();
        multiplyElements();
        deleteElements();
        stairsBackElements();
        generateUniqueNumbers();
        notEmptyStrings();
    }

    public static void reverseElements() {
        System.out.println("\n\t1. Реверс значений массива");
        int[] intArr = {1, 3, 7, 4, 2, 6, 5};
        System.out.print("Массив до модификации: ");
        printIntArr(intArr);
        int size = intArr.length;
        for (int i = 0; i < size / 2; i++) {
            int temp = intArr[i];
            intArr[i] = intArr[size - 1 - i];
            intArr[size - 1 - i] = temp;
        }
        System.out.print("Массив после модификации: ");
        printIntArr(intArr);
    }

    public static void multiplyElements() {
        System.out.println("\n\t2. Вывод произведения элементов массива");
        int[] digitArr = new int[10];
        int size = digitArr.length;
        for (int i = 0; i < size; i++) {
            digitArr[i] = i;
        }
        int result = 1;
        for (int i = 1; i < size - 1; i++) {
            result *= digitArr[i];
            System.out.print(digitArr[i] + (digitArr[i] < size - 2 ? " * " : ""));
        }
        System.out.println(" = " + result);
        System.out.printf("[%d] = %d; [%d] = %d\n", 0, digitArr[0], size, digitArr[size - 1]);
    }

    public static void deleteElements() {
        System.out.println("\n\t3. Удаление элементов массива");
        double[] doubleArr = new double[15];
        int size = doubleArr.length;
        for (int i = 0; i < size; i++) {
            doubleArr[i] = Math.random();
        }
        System.out.println("Исходный массив:");
        printDoubleArr(doubleArr);
        double middleCellValue = doubleArr[size / 2];
        int numberOfZeroCells = 0;
        for (int i = 0; i < size; i++) {
            if (doubleArr[i] > middleCellValue) {
                doubleArr[i] = 0;
                numberOfZeroCells++;
            }
        }
        System.out.println("Измененный массив:");
        printDoubleArr(doubleArr);
        System.out.println("Обнуленных ячеек: " + numberOfZeroCells);
    }

    public static void stairsBackElements() {
        System.out.println("\n\t4. Вывод элементов массива лесенкой в обратном порядке");
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        for (int i = alphabet.length - 1; i >= 0; i--) {
            for (int k = alphabet.length - 1; k >= i; k--) {
                System.out.print(alphabet[k]);
            }
            System.out.println();
        }
    }

    public static void generateUniqueNumbers() {
        System.out.println("\n\t5. Генерация уникальных чисел");
        int[] uniqIntArr = new int[30];
        for (int i = 0; i < uniqIntArr.length; i++) {
            while (true) {
                boolean isNotUnique = false;
                int randomNum = (int) (Math.random() * 40 + 60);
                for (int j = 0; j < i; j++) {
                    if (randomNum == uniqIntArr[j]) {
                        isNotUnique = true;
                        break;
                    }
                }
                if (!isNotUnique) {
                    uniqIntArr[i] = randomNum;
                    break;
                }
            }
        }
        Arrays.sort(uniqIntArr);
        int count = 0;
        for (int num : uniqIntArr) {
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
