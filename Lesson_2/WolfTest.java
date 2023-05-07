public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setWeight(50);
        wolf.setAge(3);
        wolf.setColor("серый");
        wolf.setName("Тапок");
        wolf.setGender("кобель");
        System.out.println("Кличка: " + wolf.getName());
        System.out.println("Пол: " + wolf.getGender());
        System.out.println("Цвет: " + wolf.getColor());
        System.out.println("Возраст: " + wolf.getAge());
        System.out.println("Вес: " + wolf.getWeight());
        wolf.howl();
        wolf.hunt();
        wolf.run();
        wolf.sit();
        wolf.walk();
    }
}
