package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private final Player PLAYER1;
    private final Player PLAYER2;
    private final int HIDDEN_NUMBER = (int) (Math.random() * 100 + 1);

    public GuessNumber(Player player1, Player player2) {
        this.PLAYER1 = player1;
        this.PLAYER2 = player2;
    }

    public void play() {
        do {
            if ((isGuessed(PLAYER1) || isGuessed(PLAYER2)) ||
                    PLAYER2.getCount() > PLAYER1.getNumbers().length - 1) {
                System.out.println("\nИГРА ОКОНЧЕНА!!!");
                System.out.print("Игрок " + PLAYER1.getName() + " назвал числа: ");
                printAttempts(PLAYER1);
                System.out.print("Игрок " + PLAYER2.getName() + " назвал числа: ");
                printAttempts(PLAYER2);
                PLAYER1.resetData();
                PLAYER2.resetData();
                break;
            }
        } while (true);
    }

    private boolean isGuessed(Player player) {
        System.out.print("Вводит число игрок " + player.getName() + ": ");
        Scanner scanner = new Scanner(System.in);
        player.setNumber(scanner.nextInt());
        if (player.getNumber() == HIDDEN_NUMBER) {
            System.out.println("\nИгрок " + player.getName() + " угадал число " + player.getNumber() +
                    " c " + player.getCount() + " попытки");
            return true;
        }
        if (player.getNumber() < HIDDEN_NUMBER) {
            System.out.printf("Число %d меньше того, что загадал компьютер\n", player.getNumber());
        } else {
            System.out.printf("Число %d больше того, что загадал компьютер\n", player.getNumber());
        }
        return false;
    }

    private void printAttempts(Player player) {
        int[] nonZeroNumbers = Arrays.copyOf(player.getNumbers(), player.getCount());
        for (int number : nonZeroNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
