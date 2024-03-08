package com.pingwit.part_12;

@SuppressWarnings("SpellCheckingInspection")
public class InstanceOfExample {
    public static void main(String[] args) {
        /*
        Оператор instanceof нужен, чтобы проверить, был ли объект, на который ссылается переменная, создан на основе какого-либо класса.
         */

        AnimalInstanceOf animal = new Sheep();

        if (animal instanceof Sheep) {
            System.out.println("This is an: " + animal.getClass().getName());
            Sheep sheep = (Sheep) animal;
            sheep.sayHi();
        } else {
            System.out.println("Unknown type: " + animal.getClass().getName());
        }
    }
}

interface AnimalInstanceOf {
}

class Sheep implements AnimalInstanceOf {

    public void sayHi() {
        System.out.println("hello");
    }
}

class Cow implements AnimalInstanceOf {

}