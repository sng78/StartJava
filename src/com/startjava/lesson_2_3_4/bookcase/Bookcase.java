package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    public static final int BOOKCASE_CAPACITY = 10;
    private final Book[] books = new Book[BOOKCASE_CAPACITY];
    private int numberBooks;
    private int width;

    public Book[] getBooks() {
        return Arrays.copyOf(books, numberBooks);
    }

    public int getNumberBooks() {
        return numberBooks;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void add(Book book) {
        if (numberBooks < BOOKCASE_CAPACITY) {
            books[numberBooks] = book;
            numberBooks++;
            if (book.getLength() > width) {
                width = book.getLength();
            }
            System.out.println("Книга '" + book.getTitle() + "' добавлена");
        } else {
            System.out.println("Шкаф заполнен. Книга не добавлена!");
        }
    }

    public Book find(String title) {
        int shelfNumber = findIndex(title);
        return shelfNumber != -1 ? books[shelfNumber] : null;
    }

    public boolean delete(String title) {
        int shelfNumber = findIndex(title);
        if (shelfNumber != -1) {
            int widthOld = books[shelfNumber].getLength() == width ? width : 0;
            System.arraycopy(books, shelfNumber + 1,
                    books, shelfNumber, numberBooks - 1 - shelfNumber);
            books[numberBooks - 1] = null;
            numberBooks--;
            if (widthOld != 0) {
                width = width();
            }
            return true;
        }
        return false;
    }

    public int getFreeShelves() {
        return books.length - numberBooks;
    }

    public String clearShelf(int shelfNumber) {
        if (shelfNumber < 0 || shelfNumber > 9) {
            return "Полки с номером " + shelfNumber + " нет!";
        } else if (books[shelfNumber - 1] == null) {
            return "Полка " + shelfNumber + " уже пустая!";
        } else {
            books[shelfNumber - 1] = null;
            numberBooks--;
            return "Полка " + shelfNumber + " очищена";
        }
    }

    private int findIndex(String title) {
        for (int i = 0; i < numberBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    private int width() {
        int lengthBookMax = 0;
        for (Book book : getBooks()) {
            if (book.getLength() > lengthBookMax) {
                lengthBookMax = book.getLength();
            }
        }
        return lengthBookMax;
    }
}
