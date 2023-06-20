package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[GuessNumberTest.ATTEMPTS];
    private int attempt;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public boolean addNumber(int number) {
        if (number < GuessNumberTest.MIN_NUMBER || number > GuessNumberTest.MAX_NUMBER) {
            System.out.printf("Числа должны быть от %d до %d!\n",
                    GuessNumberTest.MIN_NUMBER, GuessNumberTest.MAX_NUMBER);
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

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public int getAttempt() {
        return attempt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    public String toString() {
        return name;
    }
}
