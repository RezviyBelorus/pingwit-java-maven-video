package com.pingwit.part_28;

import org.apache.commons.lang3.StringUtils;

public class ApacheStringUtilsExample {
    public static void main(String[] args) {
        String name = null;
        if (name != null) {
            System.out.println(name.isBlank());
        }
        System.out.println("StringUtils: " + StringUtils.isBlank(name));

        System.out.println("=== capitalize ===");
        System.out.println(StringUtils.capitalize("cat"));
        System.out.println(StringUtils.capitalize("cAt"));
        System.out.println(StringUtils.capitalize("cAT"));

        System.out.println("=== isEmpty ===");
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("A"));

        System.out.println("=== isNotEmpty ===");
        System.out.println(StringUtils.isNotEmpty(null));
        System.out.println(StringUtils.isNotEmpty(" "));
        System.out.println(StringUtils.isNotEmpty("A"));

        System.out.println("=== isBlank ===");
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("A"));

        System.out.println("=== center ===");
        System.out.println(StringUtils.center("aa", 4));
        System.out.println(StringUtils.center("a", 4, "yz"));
    }
}
