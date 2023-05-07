public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.weight = 50;
        wolf.age = 3;
        wolf.color = "серый";
        wolf.name = "Тапок";
        wolf.gender = "кобель";
        System.out.println("Кличка: " + wolf.name);
        System.out.println("Пол: " + wolf.gender);
        System.out.println("Цвет: " + wolf.color);
        System.out.println("Возраст: " + wolf.age);
        System.out.println("Вес: " + wolf.weight);
        wolf.Howl();
        wolf.Hunt();
        wolf.Run();
        wolf.Sit();
        wolf.Walk();
    }
}
