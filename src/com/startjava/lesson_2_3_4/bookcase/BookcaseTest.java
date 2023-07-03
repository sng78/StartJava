package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookcaseTest {
    public static final int BOOKCASE_CAPACITY = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
        Bookcase bookcase = new Bookcase();

//        bookcase.addBook(new Book("Ирвинг Стоун", "Жажда жизни", 1973));
//        bookcase.addBook(new Book("Рэй Брэдбери", "451 градус по Фаренгейту", 1980));
//        bookcase.addBook(new Book("Даниель Дефо", "Робинзон Крузо", 1719));
//        bookcase.addBook(new Book("Николай Носов", "Приключения Незнайки и его друзей", 1953));
//        bookcase.addBook(new Book("Лев Толстой", "Война и мир (том 1)", 1865));

        while (true) {
            if (mainMenu(bookcase, scanner)) {
                pressEnter(scanner);
                displayBookcase(bookcase);
                continue;
            }
            break;
        }
    }

    private static boolean mainMenu(Bookcase bookcase, Scanner scanner) {
        System.out.print("""
                                
                1 Добавить книгу
                2 Найти книгу
                3 Удалить книгу
                4 Очистить шкаф
                5 Выйти из программы
                """);

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
                    case 1 -> addBookMenu(bookcase, scanner);
                    case 2 -> findBookMenu(bookcase, scanner);
                    case 3 -> deleteBookMenu(bookcase, scanner);
                    case 4 -> clearBookcaseMenu(bookcase, scanner);
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

    private static void addBookMenu(Bookcase bookcase, Scanner scanner) {
        System.out.print("Добавляем новую книгу\nАвтор: ");
        String author = scanner.nextLine();
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Год издания: ");
                year = Integer.parseInt(scanner.nextLine());
                bookcase.addBook(new Book(author, title, year));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, повторите ввод!!!");
                continue;
            }
            break;
        }
    }

    private static void findBookMenu(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги для ее поиска: ");
        System.out.println(bookcase.findBook(scanner.nextLine()));
    }

    private static void deleteBookMenu(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги для ее удаления: ");
        System.out.println(bookcase.deleteBook(scanner.nextLine()));
    }

    private static void clearBookcaseMenu(Bookcase bookcase, Scanner scanner) {
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
        int widthBookcase = widthShelf(bookcase);
        printShelf(widthBookcase);
        for (Book book : bookcase.getBooks()) {
            printBook(widthBookcase, book);
            printShelf(widthBookcase);
        }
        if (bookcase.getBooks().length < BOOKCASE_CAPACITY) {
            printBook(widthBookcase, null);
            printShelf(widthBookcase);
        }
    }

    private static int widthShelf(Bookcase bookcase) {
        int lengthBookMax = 0;
        for (Book book : bookcase.getBooks()) {
            if (book.getLength() > lengthBookMax) {
                lengthBookMax = book.getLength();
            }
        }
        return lengthBookMax;
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
