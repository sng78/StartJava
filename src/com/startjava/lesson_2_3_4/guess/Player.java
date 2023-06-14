package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    public int[] numbers = new int[10];
    private int attempt;

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

    public void addNumber(int number) {
        if (attempt < numbers.length) {
            numbers[attempt] = number;
            attempt++;
        }
        if (attempt == numbers.length) {
            System.out.println("У игрока " + name + " закончились попытки");
        }
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    public int[] nonZeroAttempts() {
        return Arrays.copyOf(getNumbers(), getAttempt());
    }
}
