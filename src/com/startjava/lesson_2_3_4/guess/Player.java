package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[10];
    private int attempt;
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getAttempt() {
        return attempt;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public boolean addNumber(int number) {
        if (number < 1 || number > 100) {
            System.out.println("Числа должны быть от 1 до 100!");
            return false;
        }
        if (attempt < numbers.length) {
            numbers[attempt] = number;
            attempt++;
        }
        if (attempt == numbers.length) {
            System.out.println("У игрока " + name + " закончились попытки");
        }
        return true;
    }

    public void clearAttempts() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    public int[] nonZeroAttempts() {
        return Arrays.copyOf(getNumbers(), getAttempt());
    }

    public String toString() {
        return name;
    }
}
