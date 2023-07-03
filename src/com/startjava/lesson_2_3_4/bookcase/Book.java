package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    private final String author;
    private final String title;
    private final int year;
    private final int length;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        length = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}
