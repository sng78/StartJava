public class Calculator {
    private int num1;
    private int num2;
    private String sign;

    public Calculator(int num1, String sign, int num2) {
        this.num1 = num1;
        this.sign = sign;
        this.num2 = num2;
    }

    public void calculate() {
        System.out.print("Результат вычисления: ");
        switch (sign) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            case "^":
                int result = 1;
                for (int i = 0; i < num2; i++) {
                    result *= num1;
                }
                System.out.println(result);
                break;
            case "%":
                System.out.println(num1 % num2);
                break;
            default:
                System.out.println("Недопустимая операция!");
        }
    }
}
