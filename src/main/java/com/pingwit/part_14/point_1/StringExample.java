package com.pingwit.part_14.point_1;

import java.util.Arrays;

@SuppressWarnings("SpellCheckingInspection")
public class StringExample {
    public static void main(String[] args) {
        /*
        Класс String в Java предназначен для работы со строками в Java.
        Все строковые литералы, определенные в Java программе (например, "Egorka") — это экземпляры класса String.

        Ключевые характеристики:
        1. Класс String в Java — это final класс, который не может иметь потомков.
        2. Класс String — immutable класс, то есть его объекты не могут быть изменены после создания.
        Любые операции над объектом String, результатом которых должен быть объект класса String, приведут к созданию нового объекта.
        Благодаря своей неизменности, объекты класса String являются потокобезопасными и могут быть использованы в многопоточной среде.
        Каждый объект в Java может быть преобразован в строку через метод toString, унаследованный всеми Java-классами от класса Object.
        3. Объекты класса String хранятся в string pool, который расположен в heap
        */

        String name = "   Egorka";
        name = name.concat(" Pushkin   ");
        System.out.println(name);
        System.out.println(name.length());

        name = name.trim();
        System.out.println(name.length());
        System.out.println(name);

        System.out.println(name.startsWith("Ego"));
        System.out.println(name.endsWith("Pushkin"));

        System.out.println(name.startsWith("Pushkin", 7));

        String nameLowerCase = "egorka Pushkin";
        System.out.println(name.equals(nameLowerCase));
        System.out.println(name.equalsIgnoreCase(nameLowerCase));

        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());

        System.out.println(name.charAt(1));
        System.out.println(name.indexOf("E"));
        System.out.println(name.indexOf("E", 1));

        System.out.println("===");
        String number = "    1   ";
        System.out.println(number.length());
        System.out.println(number.stripLeading());
        System.out.println(number.stripTrailing());
        number = number.stripTrailing();
        System.out.println(number.length());

        System.out.println("===");
        String emptyString = " \n ";
        System.out.println(emptyString.isBlank());
        System.out.println(emptyString.isEmpty());

        String duplicates = "111";
        System.out.println(duplicates);
        duplicates = duplicates.replace("1", "2");
        System.out.println(duplicates);

        System.out.println(name.contains("egorka"));
        System.out.println(duplicates.contains("2"));


        System.out.println("===");
        String csv = "1,2,3,4,5";
        String[] split = csv.split(",");
        System.out.println(Arrays.toString(split));

        System.out.println(csv.substring(0));
        System.out.println(csv.substring(1));
        System.out.println(csv.substring(4, 6));

        int index = csv.indexOf("33");
        String substring;
        if (index >= 0) {
            substring = csv.substring(index);
        } else {
            substring = "";
        }

        System.out.println(substring);
    }
}
