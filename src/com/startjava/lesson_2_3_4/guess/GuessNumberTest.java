package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static final int NUMBER_PLAYERS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = createPlayers(scanner);

        String option = "yes";
        do {
            if ("yes".equals(option)) {
                GuessNumber game = new GuessNumber(players);
                game.play();
            }
            System.out.print("Хотите продолжить игру? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }

    public static Player[] createPlayers(Scanner scanner) {
        Player[] players = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            System.out.printf("Введите имя %d игрока: ", i + 1);
            players[i] = new Player(scanner.nextLine());
        }
        return players;
    }
}
