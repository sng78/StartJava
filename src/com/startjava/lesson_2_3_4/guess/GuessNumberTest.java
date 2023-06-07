package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        System.out.print("Введите имя второго игрока: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);

        String repeat = "yes";
        while (repeat.equals("yes")) {
            GuessNumber game = new GuessNumber(player1, player2);
            System.out.println("\nИГРА НАЧИНАЕТСЯ! Компьютер загадал число от 1 до 100!");
            System.out.println("У каждого игрока по 10 попыток!\n");
            game.play();
            System.out.print("Хотите продолжить игру? [yes / no] ");
            repeat = scanner.next();
            if (repeat.equals("no")) {
                System.out.println();
                break;
            }
        }
    }
}
