package com.startjava.lesson_1.base;

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
            System.out.printf("Числа равны %d\n", num1);
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
        } else {
            System.out.println("Число равно " + num1);
        }

        System.out.println("\n\t4. Поиск одинаковых цифр в числах");
        num1 = 100;
        num2 = 101;
        int numFirstOnes = num1 % 10;
        int numFirstTens = num1 / 10 % 10;
        int numFirstHundreds = num1 / 100;
        int numSecondOnes = num2 % 10;
        int numSecondTens = num2 / 10 % 10;
        int numSecondHundreds = num2 / 100;
        if (numFirstOnes != numSecondOnes && numFirstTens != numSecondTens && numFirstHundreds != numSecondHundreds) {
            System.out.printf("В числах %d и %d равных цифр нет\n", num1, num2);
        } else {
            if (numFirstOnes == numSecondOnes) {
                System.out.printf("Одинаковые цифры %d в разряде 1\n", numFirstOnes);
            }
            if (numFirstTens == numSecondTens) {
                System.out.printf("Одинаковые цифры %d в разряде 2\n", numFirstTens);
            }
            if (numFirstHundreds == numSecondHundreds) {
                System.out.printf("Одинаковые цифры %d в разряде 3\n", numFirstHundreds);
            }
        }

        System.out.println("\n\t5. Определение символа по его коду");
        char symbol = '\u0057';
        System.out.print(symbol + " - ");
        if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("маленькая латинская буква");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("большая латинская буква");
        } else if (symbol >= '0' && symbol <= '9') {
            System.out.println("цифра");
        } else {
            System.out.println("не латинская буква и не число");
        }

        System.out.println("\n\t6. Подсчет суммы вклада и начисленных банком %");
        int deposit = 300_000;
        int rate = 10;
        if (deposit < 100_000) {
            rate = 5;
        } else if (deposit >= 100_000 && deposit <= 300_000) {
            rate = 7;
        }
        System.out.println("Сумма вклада: " + deposit);
        int profitPerYear = deposit * rate / 100;
        System.out.println("Начисленный процент: " + profitPerYear);
        System.out.println("Итоговая сумма с процентами: " + (deposit + profitPerYear));

        System.out.println("\n\t7. Определение оценки по предметам");
        int historyPercent = 59;
        int historyScore = 5;
        if (historyPercent <= 60) {
            historyScore = 2;
        } else if (historyPercent > 60 && historyPercent <= 73) {
            historyScore = 3;
        } else if (historyPercent > 73 && historyPercent <= 91) {
            historyScore = 4;
        }
        int programmingPercent = 92;
        int programmingScore = 5;
        if (programmingPercent <= 60) {
            programmingScore = 2;
        } else if (programmingPercent > 60 && programmingPercent <= 73) {
            programmingScore = 3;
        } else if (programmingPercent > 73 && programmingPercent <= 91) {
            programmingScore = 4;
        }
        System.out.println("Оценки по предметам:");
        System.out.println(historyScore + " история");
        System.out.println(programmingScore + " программирование");
        System.out.printf("Средний балл оценок по предметам: %.0f\n",
                ((double) (historyScore + programmingScore) / 2));
        System.out.println("Средний % по предметам: " + ((historyPercent + programmingPercent) / 2));

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
        if (amount > (hundredUsdInAtm * 100 + tenUsdInAtm * 10 + oneUsdInAtm)) {
            System.out.println("Банкнот не хватает!");
        } else {
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
