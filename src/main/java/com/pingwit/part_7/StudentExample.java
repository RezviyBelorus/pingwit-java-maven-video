package com.pingwit.part_7;

public class StudentExample {
    public static void main(String[] args) {
        String name = "Egorka";
        String surname = "Pingwit";

        Student egorka = new Student(name, surname);
        System.out.println(egorka.name);
        System.out.println(egorka.surname);

        Student randomStudent = new Student();
        System.out.println(randomStudent.name);
        System.out.println(randomStudent.surname);

        Student olya = new Student("Olya", 25);
        System.out.println(olya.name);
        System.out.println(olya.surname);
        System.out.println(olya.age);

    }
}
