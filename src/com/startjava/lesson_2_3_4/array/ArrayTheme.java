package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        reverseElements();
        multiplyElements();
        deleteElements();
        stairsBackElements();
        generateUniqueNumbers();
        copyNonEmptyStrings();
    }

    public static void reverseElements() {
        System.out.println("\n\t1. Реверс значений массива");
        int[] intArr = {1, 3, 7, 4, 2, 6, 5};
        System.out.print("Массив до модификации: ");
        printIntArr(intArr);
        int len = intArr.length - 1;
        for (int i = 0; i < len; i++, len--) {
            int temp = intArr[i];
            intArr[i] = intArr[len];
            intArr[len] = temp;
        }
        System.out.print("Массив после модификации: ");
        printIntArr(intArr);
    }

    public static void multiplyElements() {
        System.out.println("\n\t2. Вывод произведения элементов массива");
        int[] multipliers = new int[10];
        int size = multipliers.length;
        for (int i = 0; i < size; i++) {
            multipliers[i] = i;
        }
        int result = 1;
        for (int i = 1; i < size - 1; i++) {
            result *= multipliers[i];
            System.out.print(multipliers[i] + (multipliers[i] < size - 2 ? " * " : " = "));
        }
        System.out.println(result);
        System.out.printf("[%d] = %d; [%d] = %d\n", 0, multipliers[0], size, multipliers[size - 1]);
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
        int len = alphabet.length;
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int k = len - 1; k >= i; k--) {
                System.out.print(alphabet[k]);
            }
            System.out.println();
        }
    }

    public static void generateUniqueNumbers() {
        System.out.println("\n\t5. Генерация уникальных чисел");
        int[] uniqueNums = new int[30];
        for (int i = 0; i < uniqueNums.length; i++) {
            while (true) {
                boolean isNotUnique = false;
                int randomNum = (int) (Math.random() * 40 + 60);
                for (int j = 0; j < i; j++) {
                    if (randomNum == uniqueNums[j]) {
                        isNotUnique = true;
                        break;
                    }
                }
                if (!isNotUnique) {
                    uniqueNums[i] = randomNum;
                    break;
                }
            }
        }
        Arrays.sort(uniqueNums);
        int count = 0;
        for (int num : uniqueNums) {
            System.out.print(num + " ");
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }

    public static void copyNonEmptyStrings() {
        System.out.println("\n\t6. Копирование не пустых строк");
        String[] srcStrings = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        int count = 0;
        for (String str : srcStrings) {
            if (!str.isBlank()) {
                count++;
            }
        }
        String[] notEmptyStringArr = new String[count];
        int srcPos = 0;
        int destPos = 0;
        for (int i = 0; i < srcStrings.length; i++) {
            if (!srcStrings[i].isBlank()) {
                if (srcPos == -1) {
                    srcPos = i;
                }
            } else if (srcPos != -1) {
                int len = i - srcPos;
                System.arraycopy(srcStrings, srcPos, notEmptyStringArr, destPos, len);
                srcPos = -1;
                destPos += len;
            }
        }
        System.out.println("Исходный массив " + Arrays.toString(srcStrings));
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
