import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        boolean isRepeat = true;
        Scanner scanner = new Scanner(System.in);
        while (isRepeat) {
            System.out.print("Введите первое число: ");
            int num1 = Integer.parseInt(scanner.next());
            System.out.print("Введите знак математической операции: ");
            String sign = scanner.next();
            System.out.print("Введите второе число: ");
            int num2 = Integer.parseInt(scanner.next());
            Calculator calculator = new Calculator(num1, sign, num2);
            System.out.println("Результат вычисления: " + calculator.calculate());
            String more;
            do {
                System.out.print("Хотите продолжить вычисления? [yes / no] ");
                more = scanner.next();
                if (more.equals("yes")) {
                    break;
                } else if (more.equals("no")) {
                    isRepeat = false;
                    break;
                }
            } while (true);
        }
    }
}
