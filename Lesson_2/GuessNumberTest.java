import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        System.out.print("Введите имя второго игрока: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);

        boolean isRepeat = true;
        while (isRepeat) {
            int hiddenNumber = (int) (Math.random() * 100 + 1);
            GuessNumber guessNumber = new GuessNumber(player1, player2, hiddenNumber);
            System.out.println("\nИгра начинается! Компьютер загадал число от 1 до 100!");
            guessNumber.play();
            do {
                System.out.print("Хотите продолжить игру? [yes / no] ");
                String more = scanner.next();
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
