package com.pingwit.part_9;

import java.util.Objects;

public class Cat {
    private String type;
    private String color;

    public Cat(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(type, cat.type) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
