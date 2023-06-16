package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        int numberPlayers = 3;
        Player[] players = new Player[numberPlayers];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d игрока: ", i + 1);
            players[i] = new Player(scanner.nextLine());
        }

        lotPlayers(players);

        String option = "yes";
        do {
            if ("yes".equals(option)) {
                GuessNumber game = new GuessNumber(players);
                System.out.println("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от 1 до 100!");
                System.out.println("У каждого игрока по 10 попыток!\n");
                game.play();
            }
            System.out.print("Хотите продолжить игру? [yes / no] ");
            option = scanner.nextLine();
        } while (!"no".equals(option));
    }

    public static void lotPlayers(Player[] players) {
        System.out.println("\nИгроки бросают жребий");
        for (int i = 0; i < players.length; i++) {
            int rnd = (int) (Math.random() * 3);
            Player player = players[rnd];
            players[rnd] = players[i];
            players[i] = player;
        }
        System.out.println("Порядок хода игроков: " +
                Arrays.toString(players).replaceAll("[\\[\\],]", ""));
    }
}
