import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int hiddenNumber;

    public GuessNumber(Player player1, Player player2, int hiddenNumber) {
        this.player1 = player1;
        this.player2 = player2;
        this.hiddenNumber = hiddenNumber;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int player = 1;
        boolean isRepeat = true;
        while (isRepeat) {
            System.out.print("Вводит число игрок ");
            if (player == 1) {
                System.out.print(player1.getName() + ": ");
                player1.setNumber(scanner.nextInt());
                isRepeat = exam(player1);
                player = 2;
            } else {
                System.out.print(player2.getName() + ": ");
                player2.setNumber(scanner.nextInt());
                isRepeat = exam(player2);
                player = 1;
            }
        }
    }

    private boolean exam(Player player) {
        if (player.getNumber() > hiddenNumber) {
            System.out.printf("Число %d больше того, что загадал компьютер\n", player.getNumber());
        } else if (player.getNumber() < hiddenNumber) {
            System.out.printf("Число %d меньше того, что загадал компьютер\n", player.getNumber());
        } else {
            System.out.println("Поздравляю! Вы угадали! Победил игрок " + player.getName() + "!");
            return false;
        }
        return true;
    }
}
