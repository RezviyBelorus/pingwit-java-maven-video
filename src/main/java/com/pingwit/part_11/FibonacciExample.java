package com.pingwit.part_11;

public class FibonacciExample {
    public static void main(String[] args) {
        // Fibonacci -> 0,1,1,2,3,5,8,13

        int result = fibonacciRecursion(7);
        System.out.println("Result=" + result);
    }

    private static int fibonacciRecursion(int number) {
        System.out.println("number=" + number);

        if (number < 2) {
            return number;
        }

        return fibonacciRecursion(number - 1) + fibonacciRecursion((number - 2));
    }
}
