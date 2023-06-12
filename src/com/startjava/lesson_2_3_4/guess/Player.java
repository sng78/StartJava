package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private int number;
    public int[] numbers = new int[10];
    private int count;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void addNumber(int number) {
        if (count >= numbers.length - 1) {
            System.out.println("У игрока " + name + " закончились попытки");
        } else {
            numbers[count] = number;
            this.number = number;
        }
        count++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, count, 0);
        count = 0;
    }
}
