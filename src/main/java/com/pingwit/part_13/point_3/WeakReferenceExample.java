package com.pingwit.part_13.point_3;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceExample {
    public static void main(String[] args) {
        WeakReference<List<String>> weakReference = new WeakReference<>(new ArrayList<>());

        Long counter = 0L; // 31151587

        while (true) {
            List<String> strings = weakReference.get();

//            if (strings == null) {
//                System.out.println("weakReference.get() has null");
//                weakReference = new WeakReference<>(new ArrayList<>());
//            } else {
                strings.add("Egorka");
                System.out.println(strings.size());
//            }
//            counter++;
//            System.out.println(counter);
        }
    }

}
