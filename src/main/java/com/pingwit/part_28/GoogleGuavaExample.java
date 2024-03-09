package com.pingwit.part_28;

import com.google.common.collect.Lists;

import java.util.List;

public class GoogleGuavaExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<List<Integer>> table = Lists.partition(integers, 3);

        table.forEach(System.out::println);
    }
}
