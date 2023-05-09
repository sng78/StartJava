public class Calculator {
    private int num1;
    private int num2;
    private String sign;

    public Calculator(int num1, String sign, int num2) {
        this.num1 = num1;
        this.sign = sign;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String calculate() {
        switch (sign) {
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
            case "*":
                return Integer.toString(num1 * num2);
            case "/":
                return Integer.toString(num1 / num2);
            case "^":
                int result = 1;
                for (int i = 0; i < num2; i++) {
                    result *= num1;
                }
                return Integer.toString(result);
            case "%":
                return Integer.toString(num1 % num2);
            default:
                System.out.println("Недопустимая операция!");
                return "ОШИБКА!";
        }
    }
}
