package com.pingwit.part_12;

import java.lang.reflect.Field;

public class PrivateClubPrivateStaticFieldExample {
    public static void main(String[] args) throws Exception{
        PrivateClub privateClub = new PrivateClub();

        System.out.println(privateClub);
        System.out.println(PrivateClub.SERIAL_VERSION);

        Class<PrivateClub> privateClubClass = PrivateClub.class;
        Field[] declaredFields = privateClubClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("SERIAL_VERSION")) {
                declaredField.setAccessible(true);
                declaredField.set(privateClub, 123L);
            }
        }

        System.out.println(privateClub);
        System.out.println(PrivateClub.SERIAL_VERSION);
    }
}
