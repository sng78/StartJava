public class IfElseStatementTheme {

    public static void main(String[] args) {
        System.out.println("\n\t1. Перевод псевдокода на язык Java");
        int age = 21;
        boolean isMale = true;
        double height = 1.78;
        if (age > 20) {
            System.out.println("Возраст больше 20, и равен " + age);
        } else {
            System.out.println("Возраст меньше или равен 20");
        }
        if (!isMale) {
            System.out.println("Женщина");
        } else {
            System.out.println("Настоящий мужик!");
        }
        if (height < 1.80) {
            System.out.println("Рост - невысокий");
        } else {
            System.out.println("Высокий рост");
        }
        char firstLetterName = "Serge".charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Ваше имя Michael?");
        } else if (firstLetterName == 'I') {
            System.out.println("Ваше имя Ivan?");
        } else {
            System.out.println("Ваше имя начинается не на I, и не на M");
        }

        System.out.println("\n\t2. Поиск max и min числа");
        int num1 = 365;
        int num2 = 366;
        if (num1 > num2) {
            System.out.printf("Число %d больше числа %d\n", num1, num2);
        } else if (num1 < num2) {
            System.out.printf("Число %d меньше числа %d\n", num1, num2);
        } else {
            System.out.println("Числа равны");
        }

        System.out.println("\n\t3. Проверка числа");
        num1 = -4;
        if (num1 != 0) {
            System.out.print("Число " + num1);
            if (num1 % 2 == 0) {
                System.out.print(" - четное,");
            } else {
                System.out.print(" - нечетное,");
            }
            if (num1 > 0) {
                System.out.println(" положительное");
            } else {
                System.out.println(" отрицательное");
            }
        }

        System.out.println("\n\t4. Поиск одинаковых цифр в числах");
        num1 = 100;
        num2 = 101;
        boolean isOnesEquals = false;
        boolean isTensEquals = false;
        boolean isHundredsEquals = false;
        if (num1 % 10 == num2 % 10) {
            isOnesEquals = true;
        }
        if ((num1 / 10 % 10) == (num2 / 10 % 10)) {
            isTensEquals = true;
        }
        if ((num1 / 100) == (num2 / 100)) {
            isHundredsEquals = true;
        }
        if (isOnesEquals || isTensEquals || isHundredsEquals) {
            System.out.printf("Исходные числа - %d %d\n", num1, num2);
            System.out.print("Одинаковые цифры - ");
            if (isOnesEquals) {
                System.out.print((num1 % 10) + " ");
            }
            if (isTensEquals) {
                System.out.print((num1 / 10 % 10) + " ");
            }
            if (isHundredsEquals) {
                System.out.print((num1 / 100));
            }
            System.out.print("\nНомера разрядов - ");
            if (isOnesEquals) {
                System.out.print("1 ");
            }
            if (isTensEquals) {
                System.out.print("2 ");
            }
            if (isHundredsEquals) {
                System.out.print("3");
            }
        } else {
            System.out.printf("В числах %d и %d равных цифр нет", num1, num2);
        }

        System.out.println("\n\n\t5. Определение символа по его коду");
        char symbol = '\u0057';
        System.out.print(symbol + " - ");
        if (symbol >= 97 && symbol <= 122) {
            System.out.println("маленькая латинская буква");
        } else if (symbol >= 65 && symbol <= 90) {
            System.out.println("большая латинская буква");
        } else if (symbol >= 48 && symbol <= 57) {
            System.out.println("цифра");
        } else {
            System.out.println("не латинская буква и не число");
        }

        System.out.println("\n\t6. Подсчет суммы вклада и начисленных банком %");
        int deposit = 300_000;
        int rate;
        if (deposit < 100_000) {
            rate = 5;
        } else if (deposit >= 100_000 && deposit <= 300_000) {
            rate = 7;
        } else {
            rate = 10;
        }
        System.out.println("Сумма вклада: " + deposit);
        int profitPerYear = deposit * rate / 100;
        System.out.println("Начисленный процент: " + profitPerYear);
        System.out.println("Итоговая сумма с процентами: " + (deposit + profitPerYear));

        System.out.println("\n\t7. Определение оценки по предметам");
        int historyInPercent = 59;
        int programmingInPercent = 92;
        int historyInScore;
        int programmingInScore;
        if (historyInPercent <= 60) {
            historyInScore = 2;
        } else if (historyInPercent > 60 && historyInPercent <= 73) {
            historyInScore = 3;
        } else if (historyInPercent > 73 && historyInPercent <= 91) {
            historyInScore = 4;
        } else {
            historyInScore = 5;
        }
        if (programmingInPercent <= 60) {
            programmingInScore = 2;
        } else if (programmingInPercent > 60 && programmingInPercent <= 73) {
            programmingInScore = 3;
        } else if (programmingInPercent > 73 && programmingInPercent <= 91) {
            programmingInScore = 4;
        } else {
            programmingInScore = 5;
        }
        System.out.println("Оценки по предметам:");
        System.out.println(historyInScore + " история");
        System.out.println(programmingInScore + " программирование");
        System.out.printf("Средний балл оценок по предметам: %.0f%n",
                ((double) (historyInScore + programmingInScore) / 2));
        System.out.println("Средний % по предметам: " + ((historyInPercent + programmingInPercent) / 2));

        System.out.println("\n\t8. Расчет прибыли за год");
        int rent = 5000;
        int sale = 13000;
        int costPrice = 9000;
        profitPerYear = (sale - costPrice - rent) * 12;
        System.out.print("Прибыль за год: ");
        if (profitPerYear > 0) {
            System.out.print("+");
        }
        System.out.println(profitPerYear);

        System.out.println("\n\t9. Подсчет количества банкнот");
        int amount = 567;
        int hundredUsdInAtm = 10;
        int tenUsdInAtm = 5;
        int oneUsdInAtm = 50;
        int hundredUsdCash = amount / 100;
        int tenUsdCash = amount / 10 % 10;
        int oneUsdCash = amount % 10;
        if (hundredUsdCash > hundredUsdInAtm) {
            hundredUsdCash = hundredUsdInAtm;
            amount -= hundredUsdInAtm * 100;
            tenUsdCash = amount / 10;
            if (tenUsdCash > tenUsdInAtm) {
                tenUsdCash = tenUsdInAtm;
            }
            amount -= tenUsdCash * 10;
            oneUsdCash = amount;
        }
        if (oneUsdCash > oneUsdInAtm) {
            System.out.println("Банкнот не хватает!");
        } else {
            if (hundredUsdCash != 0) {
                System.out.printf("%d банкнот номиналом 100 USD, всего - %d USD\n",
                        hundredUsdCash, hundredUsdCash * 100);
            }
            if (tenUsdCash != 0) {
                System.out.printf("%d банкнот номиналом 10 USD, всего - %d USD\n",
                        tenUsdCash, tenUsdCash * 10);
            }
            if (oneUsdCash != 0) {
                System.out.printf("%d банкнот номиналом 1 USD, всего - %d USD\n",
                        oneUsdCash, oneUsdCash);
            }
        }
    }
}
