package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final int hiddenNumber = new Random().nextInt(100) + 1;
    private final Player player1;
    private final Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        do {
            if ((isGuessed(player1) || isGuessed(player2)) ||
                    player2.getAttempt() > player1.getNumbers().length - 1) {
                System.out.println("\nИГРА ОКОНЧЕНА!!!");
                System.out.print("Игрок " + player1.getName() + " назвал числа: ");
                printAttempts(player1.nonZeroAttempts());
                System.out.print("Игрок " + player2.getName() + " назвал числа: ");
                printAttempts(player2.nonZeroAttempts());
                player1.clear();
                player2.clear();
                break;
            }
        } while (true);
    }

    private boolean isGuessed(Player player) {
        System.out.print("Вводит число игрок " + player.getName() + ": ");
        Scanner scanner = new Scanner(System.in);
        player.addNumber(scanner.nextInt());
        if (player.getNumber() == hiddenNumber) {
            System.out.println("\nИгрок " + player.getName() + " угадал число " + player.getNumber() +
                    " c " + player.getAttempt() + " попытки");
            return true;
        }
        if (player.getNumber() < hiddenNumber) {
            System.out.printf("Число %d меньше того, что загадал компьютер\n", player.getNumber());
        } else {
            System.out.printf("Число %d больше того, что загадал компьютер\n", player.getNumber());
        }
        return false;
    }

    private void printAttempts(int[] nonZeroNumbers) {
        for (int number : nonZeroNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
