package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static final int NUMBER_PLAYERS = 3;
    public static final int ROUNDS = 3;
    public static final int ATTEMPTS = 10;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = createPlayers();

        String option = "yes";
        do {
            if ("yes".equals(option)) {
                GuessNumber game = new GuessNumber(players);
                System.out.printf("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от %d до %d!",
                        MIN_NUMBER, MAX_NUMBER);
                System.out.printf("\nУ каждого игрока по %d попыток!", ATTEMPTS);
                System.out.printf("\nПо результатам %d раундов будет определен победитель!\n\n", ROUNDS);
                game.play();
            }
            System.out.print("Хотите продолжить игру? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }

    public static Player[] createPlayers() {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d игрока: ", i + 1);
            players[i] = new Player(scanner.nextLine());
        }
        return players;
    }
}
