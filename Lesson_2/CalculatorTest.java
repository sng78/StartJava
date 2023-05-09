import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        String repeat = "yes";
        Scanner scanner = new Scanner(System.in);
        while (repeat.equals("yes")) {
            System.out.print("Введите первое число: ");
            int num1 = Integer.parseInt(scanner.next());
            System.out.print("Введите знак математической операции: ");
            String sign = scanner.next();
            System.out.print("Введите второе число: ");
            int num2 = Integer.parseInt(scanner.next());
            Calculator calculator = new Calculator(num1, sign, num2);
            System.out.println("Результат вычисления: " + calculator.calculate());
            do {
                System.out.print("Хотите продолжить вычисления? [yes / no] ");
                repeat = scanner.next();
            } while (!repeat.equals("yes") && !repeat.equals("no"));
        }
    }
}