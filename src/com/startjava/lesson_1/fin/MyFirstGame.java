package com.startjava.lesson_1.fin;

public class MyFirstGame {

    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int numPc = 51;
        int numPlayer = (min + max) / 2;
        while (numPlayer != numPc) {
            if (numPlayer > numPc) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", numPlayer);
                max = numPlayer;
            } else {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", numPlayer);
                min = numPlayer;
            }
            numPlayer = (min + max) / 2;
        }
        System.out.println("Вы победили! Это число " + numPlayer);
    }
}
