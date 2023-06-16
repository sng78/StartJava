package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private int hiddenNumber = new Random().nextInt(100) + 1;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        int rounds = 0;
        System.out.println("НАЧИНАЕТСЯ РАУНД " + (rounds + 1));
        do {
            if ((isGuessed(players[0]) || isGuessed(players[1]) || isGuessed(players[2])) ||
                    players[2].getAttempt() > players[1].getNumbers().length - 1) {
                rounds++;
                System.out.printf("\nРАУНД %d ЗАВЕРШЕН!!!\n", rounds);
                for (Player player : players) {
                    System.out.print("Игрок " + player.getName() + " назвал числа: ");
                    printNonZeroAttempts(player.nonZeroAttempts());
                    player.clearAttempts();
                }
                if (rounds != 3) {
                    System.out.println("\nНАЧИНАЕТСЯ РАУНД " + (rounds + 1));
                    hiddenNumber = new Random().nextInt(100) + 1;
                } else {
                    System.out.println("\nИГРА ОКОНЧЕНА!!!");
                    if (players[0].getWins() == players[1].getWins()) {
                        System.out.println("Победителя нет! Ничья!");
                    } else {
                        for (Player player : players) {
                            if (player.getWins() == 2) {
                                System.out.println("Победил игрок " + player.getName());
                            }
                        }
                    }
                    for (Player player : players) {
                        player.clearAttempts();
                        player.setWins(0);
                    }
                    break;
                }
            }
        } while (true);
    }

    private boolean isGuessed(Player player) {
        Scanner scanner = new Scanner(System.in);

        boolean isAdd;
        do {
            System.out.print("Вводит число игрок " + player.getName() + ": ");
            isAdd = player.addNumber(scanner.nextInt());
        } while (!isAdd);

        if (player.getNumber() == hiddenNumber) {
            player.setWins(player.getWins() + 1);
            System.out.println("\nИгрок " + player.getName() + " угадал число " + player.getNumber() +
                    " c " + player.getAttempt() + " попытки");
            return true;
        }
        System.out.printf("Число %d ", player.getNumber());
        System.out.print(player.getNumber() < hiddenNumber ? "меньше" : "больше");
        System.out.println(" того, что загадал компьютер");
        return false;
    }

    public void printNonZeroAttempts(int[] nonZeroNumbers) {
        System.out.println(Arrays.toString(nonZeroNumbers).replaceAll("[\\[\\],]", ""));
    }
}
