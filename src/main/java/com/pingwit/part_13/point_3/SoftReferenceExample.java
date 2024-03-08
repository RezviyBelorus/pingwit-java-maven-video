package com.pingwit.part_13.point_3;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<List<String>> softReference = new SoftReference<>(new ArrayList<>());

        Long counter = 0L; // 31151587

        while (true) {
            List<String> strings = softReference.get();
//            Thread.sleep(1);
            strings.add(new String("Egorka"));

            counter++;
            System.out.println(counter);
        }
    }
}
