package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int ROUNDS = 3;
    public static final int ATTEMPTS = 10;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    private int hiddenNumber;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        System.out.printf("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от %d до %d!",
                MIN_NUMBER, MAX_NUMBER);
        System.out.printf("\nУ каждого игрока по %d попыток!", ATTEMPTS);
        System.out.printf("\nПо результатам %d раундов будет определен победитель!\n\n", ROUNDS);
        castLots(players);
        hiddenNumber = generateRandom();

        int round = 1;
        System.out.println("\nНАЧИНАЕТСЯ РАУНД " + round);
        while (round <= ROUNDS) {
            for (Player player : players) {
                if (player.getAttempt() != ATTEMPTS && !isGuessed(player)) {
                    continue;
                }
                System.out.printf("\nРАУНД %d ЗАВЕРШЕН!!!\n", round);
                for (Player pl : players) {
                    System.out.print("Игрок " + pl + " назвал числа: ");
                    printArray(Arrays.toString(pl.getNumbers()));
                    pl.clear();
                }
                hiddenNumber = generateRandom();
                round++;
                System.out.println(round < 4 ? "\nНАЧИНАЕТСЯ РАУНД " + round : "\nИГРА ОКОНЧЕНА!!!");
                break;
            }
        }

        printWinner(players);
        for (Player player : players) {
            player.clear();
            player.setScore(0);
        }
    }

    private void castLots(Player[] players) {
        System.out.println("Игроки бросают жребий");
        for (int i = 0; i < players.length; i++) {
            int rnd = (int) (Math.random() * players.length);
            Player player = players[rnd];
            players[rnd] = players[i];
            players[i] = player;
        }
        System.out.print("Порядок хода игроков: ");
        printArray(Arrays.toString(players));
    }

    private int generateRandom() {
        return new Random().nextInt(MAX_NUMBER) + MIN_NUMBER;
    }

    private boolean isGuessed(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdd;
        do {
            System.out.print("Вводит число игрок " + player + ": ");
            isAdd = player.addNumber(scanner.nextInt());
        } while (!isAdd);

        if (player.getNumber() == hiddenNumber) {
            player.setScore(player.getScore() + 1);
            System.out.println("\nИгрок " + player + " угадал число " + player.getNumber() +
                    " c " + player.getAttempt() + " попытки");
            return true;
        }
        System.out.printf("Число %d ", player.getNumber());
        System.out.print(player.getNumber() < hiddenNumber ? "меньше" : "больше");
        System.out.println(" того, что загадал компьютер");
        return false;
    }

    private void printArray(String str) {
        System.out.println(str.replaceAll("[\\[\\],]", ""));
    }

    private void printWinner(Player[] players) {
        Player winner = players[0];
        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > winner.getScore()) {
                winner = players[i];
            } else if (players[i].getScore() == winner.getScore()) {
                winner = null;
                break;
            }
        }
        System.out.print("По результатам 3 раундов ");
        System.out.println(winner == null ? "победителя нет!" : "победил игрок " + winner);
    }
}
