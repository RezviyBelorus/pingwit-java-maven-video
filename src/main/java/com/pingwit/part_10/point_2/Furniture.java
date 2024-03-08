package com.pingwit.part_10.point_2;

public abstract class Furniture {

    protected String color;
    protected String material;

    public Furniture(String color, String material) {
        System.out.println("Hello from Furniture");
        this.color = color;
        this.material = material;
    }

    protected boolean isRare() {
        return false;
    }

    protected abstract String getProducer();

    protected String model() {
        return "Top model";
    }

}
