package com.pingwit.part_10.point_2;

@SuppressWarnings("SpellCheckingInspection")
public class AbstractClassExample {
    public static void main(String[] args) {
        /*
        Абстрактный класс в Java — это класс, который не может быть использован для создания объектов.
        Звучит как что-то бесполезное? Но именно в этом и крет его смысл.
        Вместо создания объектов абстрактный класс служит как базовый элемент для других классов.
         */

        Furniture furniture = new Chair("white", "wood", true);
        System.out.println(furniture.model());

        System.out.println("=== BabyChair ===");
        BabyChair babyChair = new BabyChair(null, null, false);
    }
}
