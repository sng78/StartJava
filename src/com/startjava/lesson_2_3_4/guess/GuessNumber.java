package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.startjava.lesson_2_3_4.guess.GuessNumberTest.ATTEMPTS;
import static com.startjava.lesson_2_3_4.guess.GuessNumberTest.ROUNDS;

public class GuessNumber {
    private int hiddenNumber = new Random().nextInt(100) + 1;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        castLots(players);

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
                    printAttempts(Arrays.copyOf(pl.getNumbers(), pl.getAttempt()));
                    pl.clear();
                }
                hiddenNumber = new Random().nextInt(100) + 1;
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

    private static void castLots(Player[] players) {
        System.out.println("Игроки бросают жребий");
        for (int i = 0; i < players.length; i++) {
            int rnd = (int) (Math.random() * players.length);
            Player player = players[rnd];
            players[rnd] = players[i];
            players[i] = player;
        }
        System.out.println("Порядок хода игроков: " +
                Arrays.toString(players).replaceAll("[\\[\\],]", ""));
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

    private void printAttempts(int[] numbers) {
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private void printWinner(Player[] players) {
        int maxScore = players[0].getScore();
        Player winner = null;
        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > maxScore) {
                maxScore = players[i].getScore();
                winner = players[i];
            } else if (players[i].getScore() == maxScore) {
                winner = null;
                break;
            }
        }
        System.out.print("По результатам 3 раундов ");
        System.out.println(winner == null ? "победителя нет!" : "победил игрок " + winner);
    }
}
