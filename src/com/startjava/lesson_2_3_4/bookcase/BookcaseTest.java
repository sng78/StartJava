package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookcaseTest {
//    public static final int BOOKCASE_CAPACITY = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
        Bookcase bookcase = new Bookcase();

//        bookcase.add(new Book("Ирвинг Стоун", "Жажда жизни", 1973));
//        bookcase.add(new Book("Рэй Брэдбери", "451 градус по Фаренгейту", 1980));
//        bookcase.add(new Book("Даниель Дефо", "Робинзон Крузо", 1719));
//        bookcase.add(new Book("Николай Носов", "Приключения Незнайки и его друзей", 1953));
//        bookcase.add(new Book("Лев Толстой", "Война и мир (том 1)", 1865));

        while (true) {
            displayMenu();
            if (select(bookcase, scanner)) {
                pressEnter(scanner);
                displayBookcase(bookcase);
                continue;
            }
            System.out.println("\nПРОГРАММА ЗАВЕРШИЛА РАБОТУ, ДО ВСТЕЧИ!!!");
            break;
        }
    }

    private static void displayMenu() {
        System.out.print("""
                                
                1 Добавить книгу
                2 Найти книгу
                3 Удалить книгу
                4 Очистить шкаф
                5 Выйти из программы
                """);
    }

    private static boolean select(Bookcase bookcase, Scanner scanner) {
        while (true) {
            System.out.print("     Ваш выбор: ");
            String menuItem = scanner.nextLine();
            try {
                int option = Integer.parseInt(menuItem);
                if (option < 1 || option > 5) {
                    System.out.println("Число должно быть от 1 до 5!!!");
                    continue;
                }
                switch (option) {
                    case 1 -> addBook(bookcase, scanner);
                    case 2 -> findBook(bookcase, scanner);
                    case 3 -> deleteBook(bookcase, scanner);
                    case 4 -> clearBookcase(bookcase, scanner);
                    default -> {
                        return false;
                    }
                }
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, повторите ввод!!!");
            }
        }
    }

    private static void addBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Добавляем новую книгу\nАвтор: ");
        String author = scanner.nextLine();
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Год издания: ");
                year = Integer.parseInt(scanner.nextLine());
                bookcase.add(new Book(author, title, year));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, повторите ввод!!!");
                continue;
            }
            break;
        }
    }

    private static void findBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги для ее поиска: ");
        String title = scanner.nextLine();
        Book book = bookcase.find(title);
        System.out.print("Книга '" + title + "' " + (book != null ? "найдена - " + book : "не найдена!"));
    }

    private static void deleteBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги для ее удаления: ");
        String title = scanner.nextLine();
        System.out.println("Книга '" + title + "' " + (bookcase.delete(title) ? "удалена" :
                "не удалена, так как не найдена!"));
    }

    private static void clearBookcase(Bookcase bookcase, Scanner scanner) {
        String option;
        do {
            System.out.print("Очистить шкаф, Вы уверены? [yes / no] ");
            option = scanner.nextLine();
            if (option.equals("yes")) {
                int occupiedShelves = bookcase.getNumberBooks();
                if (occupiedShelves == 0) {
                    System.out.println("Шкаф и так пуст, очищать нет необходимости!");
                } else {
                    for (int i = 1; i < occupiedShelves + 1; i++) {
                        System.out.println(bookcase.clearShelf(i));
                    }
                    bookcase.setWidth(0);
                }
                break;
            }
        } while (!option.equals("no"));
    }

    private static void pressEnter(Scanner scanner) {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>");
        String key = " ";
        while (!key.equals("")) {
            key = scanner.nextLine();
        }
        System.out.println();
    }

    private static void displayBookcase(Bookcase bookcase) {
        System.out.printf("     В шкафу книг - %d, свободных полок - %d\n",
                bookcase.getNumberBooks(), bookcase.getFreeShelves());
        int widthBookcase = bookcase.getWidth();
        printShelf(widthBookcase);
        for (Book book : bookcase.getBooks()) {
            printBook(widthBookcase, book);
            printShelf(widthBookcase);
        }
        if (bookcase.getBooks().length < Bookcase.BOOKCASE_CAPACITY) {
            printBook(widthBookcase, null);
            printShelf(widthBookcase);
        }
    }

    private static void printShelf(int widthBookcase) {
        System.out.println("+" + "-".repeat(widthBookcase + 2) + "+");
    }

    private static void printBook(int widthBookcase, Book book) {
        System.out.print("| ");
        System.out.print(book != null ? (book + " ".repeat(widthBookcase - book.getLength()))
                : " ".repeat(widthBookcase));
        System.out.println(" |");
    }
}
