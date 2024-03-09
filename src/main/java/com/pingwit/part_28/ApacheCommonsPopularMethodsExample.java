package com.pingwit.part_28;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Map;

public class ApacheCommonsPopularMethodsExample {
    public static void main(String[] args) {
        System.out.println(NumberUtils.isDigits("777"));
        System.out.println(NumberUtils.isDigits("777L"));
        System.out.println(NumberUtils.isDigits("777!"));
        System.out.println(NumberUtils.isDigits("777\u0030"));
        System.out.println('\u0030');

        System.out.println("=== NumberUtils.isCreatable() ===");
        System.out.println(NumberUtils.isCreatable("777L"));
        Number number = NumberUtils.createNumber("777L");
        System.out.println(number);
        Long asLong = NumberUtils.createLong(number.toString());
        System.out.println(asLong);

        System.out.println("=== NumberUtils.max() ===");
        int max = NumberUtils.max(55, 66, 9);
        System.out.println(max);
        int[] ints = {55, 66, 200, 9, 100};
        System.out.println("Min from array: " + NumberUtils.min(ints));

        System.out.println("=== ArrayUtils.toMap() ===");
        String[][] stringTable = {{"1", "one"}, {"2", "two"}, {"3", "three"}};
        Map<Object, Object> stringTableAsMap = ArrayUtils.toMap(stringTable);
        System.out.println(stringTableAsMap);

        Integer[][] table = {{55, 1, 4}, {1, 2, 3}};
        System.out.println(ArrayUtils.toMap(table));

        System.out.println("=== SystemUtils ===");
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getUserDir());

        Triple<String, String, Integer> triple = Triple.of("Egorka", "Pingwit", 25);
        System.out.println(triple.getMiddle());
    }
}
