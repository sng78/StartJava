public class MyFirstGame {

    public static void main(String[] args) {
        int numPC = 3;
        int numPlayer = 50;
        if (numPlayer > numPC) {
            System.out.printf("Число %d больше того, что загадал компьютер", numPlayer);
        } else if (numPlayer < numPC) {
            System.out.printf("Число %d меньше того, что загадал компьютер", numPlayer);
        } else {
            System.out.println("Вы победили!");
        }
    }
}
