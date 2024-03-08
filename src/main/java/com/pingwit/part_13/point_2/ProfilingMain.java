package com.pingwit.part_13.point_2;

import java.util.ArrayList;
import java.util.List;

public class ProfilingMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> names2 = new ArrayList<>();

        int counter = 0;
        while (true) {
            String name = new String("Egorka");
//            String name = "Egorka";
            names.add(name);
            names2.add(name);

            System.out.println(name);
            counter++;
            System.out.println(counter);
        }
    }
    // String name = new String("Egorka"); -> 13 845 150
    // String name = "Egorka"; -> 31 151 587

}
