package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    private int numberBooks;
    private final Book[] books = new Book[BookcaseTest.BOOKCASE_CAPACITY];

    public void addBook(Book book) {
        if (numberBooks < 10) {
            books[numberBooks] = book;
            numberBooks++;
            System.out.println("Книга '" + book.getTitle() + "' добавлена");
        } else {
            System.out.println("Шкаф заполнен. Книга не добавлена!");
        }
    }

    public String findBook(String bookTitle) {
        String outputMessage = "Книга '" + bookTitle + "' ";
        int shelfNumber = findTitle(bookTitle);
        outputMessage += (shelfNumber != -1 ? ("найдена на " + (shelfNumber + 1) + " полке") : "не найдена!");
        return outputMessage;
    }

    public String deleteBook(String bookTitle) {
        StringBuilder sb = new StringBuilder();
        sb.append("Книга '").append(bookTitle).append("' ");
        int shelfNumber = findTitle(bookTitle);
        if (shelfNumber != -1) {
            System.arraycopy(books, shelfNumber + 1,
                    books, shelfNumber, numberBooks - 1 - shelfNumber);
            books[numberBooks - 1] = null;
            numberBooks--;
            sb.append("удалена");
        } else {
            sb.append("не удалена, так как не найдена!");
        }
        return sb.toString();
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, numberBooks);
    }

    public int getNumberBooks() {
        return numberBooks;
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

    private int findTitle(String bookTitle) {
        for (int i = 0; i < numberBooks; i++) {
            if (books[i] != null && books[i].getTitle().equals(bookTitle)) {
                return i;
            }
        }
        return -1;
    }
}
