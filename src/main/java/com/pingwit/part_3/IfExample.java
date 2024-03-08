package com.pingwit.part_3;

public class IfExample {
    public static void main(String[] args) {
        int x = 400;
        int y = 200;

        boolean result = x == y;

        if (result) {
            System.out.println("Hello from If"); // if() operator
            System.out.println("Happy end");
        } else if (x > y){
            System.out.println("x > y");
        } else {
            System.out.println("x < y");
        }

        //if - else - if
    }

}
