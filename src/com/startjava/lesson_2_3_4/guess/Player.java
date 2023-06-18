package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

import static com.startjava.lesson_2_3_4.guess.GuessNumberTest.ATTEMPTS;

public class Player {
    private final String name;
    private final int[] numbers = new int[ATTEMPTS];
    private int attempt;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int getNumber() {
        return numbers[attempt - 1];
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

    public int[] getNumbers() {
        return numbers;
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
