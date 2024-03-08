package com.pingwit.part_7;

public class Student {
    static String message;

    String name;
    String surname;
    String group;
    int age;
    double height;
    Boolean expelled;
    boolean happy;

    static {
        System.out.println("Static init block 1");
        message = "dfdf";
    }

    static {
        System.out.println("Static init block 2");
    }

    {
        System.out.println("Init block 1");
        happy = true;
    }

    {
        System.out.println("Init block 2");
    }

    public Student(String name, String surname) {
        System.out.println("Hello from constructor");
        this.name = name;
        this.surname = surname;
        this.happy = false;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        this("RandomName", "RandomSurname");
        System.out.println("Hello from default constructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", expelled=" + expelled +
                ", happy=" + happy +
                '}';
    }
}
