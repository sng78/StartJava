package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {

    public static void main(String[] args) {
        String mark = "Mark-1";
        float height = 85.34f;

        Jaeger jaeger1 = new Jaeger();
        jaeger1.setModelName("Cherno Alpha");
        jaeger1.setMark(mark);
        jaeger1.setOrigin("Russia");
        jaeger1.setHeight(height);
        jaeger1.setWeight(2.412f);
        jaeger1.setSpeed(3);
        jaeger1.setStrength(10);
        jaeger1.setArmor(10);

        Jaeger jaeger2 = new Jaeger("Coyote Tango", mark, "Japan",
                height, 2.312f, 5, 7, 4);

        System.out.println("Имя первого робота - " + jaeger1.getModelName());
        System.out.println("Имя второго робота - " + jaeger2.getModelName());
        jaeger1.drift();
        jaeger2.drift();
        jaeger1.move();
        jaeger2.move();
        System.out.println(jaeger1.scanKaiju());
        System.out.println(jaeger2.scanKaiju());
        jaeger2.useVortexCannon();
        System.out.println("Произведем модернизацию робота " + jaeger1.getModelName());
        jaeger1.setSpeed(4);
        System.out.println("Скорость робота увеличена до " + jaeger1.getSpeed());
        jaeger1.move();
    }
}
