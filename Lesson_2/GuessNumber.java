import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int hiddenNumber = (int) (Math.random() * 100 + 1);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        do {
            if (isGuessed(player1) || isGuessed(player2)) {
                break;
            }
        } while (true);
    }

    private boolean isGuessed(Player player) {
        System.out.print("Вводит число игрок " + player.getName() + ": ");
        Scanner scanner = new Scanner(System.in);
        player.setNumber(scanner.nextInt());
        if (player.getNumber() == hiddenNumber) {
            System.out.println("Поздравляю! Вы угадали! Победил игрок " + player.getName() + "!");
            return true;
        }
        if (player.getNumber() < hiddenNumber) {
            System.out.printf("Число %d меньше того, что загадал компьютер\n", player.getNumber());
        } else {
            System.out.printf("Число %d больше того, что загадал компьютер\n", player.getNumber());
        }
        return false;
    }
}
