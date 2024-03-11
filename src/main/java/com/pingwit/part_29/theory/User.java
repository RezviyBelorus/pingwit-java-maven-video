package com.pingwit.part_29.theory;

import java.util.List;

record User(
        String name,
        Integer age,
        Boolean isStudent,
        UserAddress address,
        List<String> hobbies
) {
}

record UserAddress(
        String city,
        Integer zip
) {

}