package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static final int NUMBER_PLAYERS = 3;
    public static final Player[] PLAYERS = new Player[NUMBER_PLAYERS];
    public static final int ROUNDS = 3;
    public static final int ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createPlayers(PLAYERS);

        String option = "yes";
        do {
            if ("yes".equals(option)) {
                GuessNumber game = new GuessNumber(PLAYERS);
                System.out.println("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от 1 до 100!");
                System.out.printf("У каждого игрока по %d попыток!\n\n", ATTEMPTS);
                game.play();
            }
            System.out.print("Хотите продолжить игру? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }

    public static void createPlayers(Player[] players) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d игрока: ", i + 1);
            players[i] = new Player(scanner.nextLine());
        }
    }
}
