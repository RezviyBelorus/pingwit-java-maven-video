package com.pingwit.part_12;

import java.lang.reflect.Field;

public class PrivateClubPrivateFieldExample {
    public static void main(String[] args) throws Exception {
        PrivateClub privateClub = new PrivateClub();

        System.out.println(privateClub);

        Class<PrivateClub> privateClubClass = PrivateClub.class;
        Field[] declaredFields = privateClubClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("clubName")) {
                declaredField.setAccessible(true);
                declaredField.set(privateClub, "clubName");
            }
        }

        System.out.println(privateClub);
    }
}
