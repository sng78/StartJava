package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String NAME;
    private int number;
    public int[] numbers = new int[10];
    private int count;

    public Player(String name) {
        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

    public int getNumber() {
        return number;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getCount() {
        return count;
    }

    public void setNumber(int number) {
        if (count >= numbers.length - 1) {
            System.out.println("У игрока " + NAME + " закончились попытки");
        } else {
            numbers[count] = number;
            this.number = number;
        }
        count++;
    }

    public void resetData() {
        Arrays.fill(numbers, 0, count, 0);
        count = 0;
    }
}
