package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int ATTEMPTS = 10;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    private static final int ROUNDS = 3;
    private final Player[] players;
    private int hiddenNumber;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        System.out.printf("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от %d до %d!",
                MIN_NUMBER, MAX_NUMBER);
        System.out.printf("\nУ каждого игрока по %d попыток!", ATTEMPTS);
        System.out.printf("\nПо результатам %d раундов будет определен победитель!\n\n", ROUNDS);
        castLots(players);

        for (int round = 1; round <= ROUNDS; round++) {
            hiddenNumber = generateRandom();
            System.out.println("\nНАЧИНАЕТСЯ РАУНД " + round);
            boolean cont = true;
            while (cont) {
                for (Player player : players) {
                    if (player.getAttempt() != ATTEMPTS && !isGuessed(player)) {
                        continue;
                    }
                    if (player.getNumber() != hiddenNumber) {
                        System.out.println("\nПобедителя в раунде нет!");
                    }
                    System.out.printf("\nРАУНД %d ЗАВЕРШЕН!!!\n", round);
                    for (Player pl : players) {
                        System.out.print("Игрок " + pl + " назвал числа: ");
                        printAllNumbers(pl.getNumbers());
                        pl.clear();
                    }
                    cont = false;
                    break;
                }
            }
        }
        System.out.print("\nИГРА ОКОНЧЕНА!!!\nПо результатам 3 раундов ");
        System.out.println(hasWin(players) == null ? "победителя нет!\n" :
                "победил игрок " + hasWin(players) + "\n");
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
        for (Player player : players) {
            System.out.print(player + " ");
        }
        System.out.println();
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

    private void printAllNumbers(int[] numbers) {
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private Player hasWin(Player[] players) {
        boolean isUnique = true;
        Player winner = players[0];
        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > winner.getScore()) {
                winner = players[i];
                isUnique = true;
            } else if (players[i].getScore() == winner.getScore()) {
                isUnique = false;
            }
        }
        return isUnique ? winner : null;
    }
}
