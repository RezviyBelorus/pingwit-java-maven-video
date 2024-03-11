package com.pingwit.part_29.read;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
record User(
        String username,
        String email,
        String password,
        String fullName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate birthdate,
        String gender,
        List<String> interests,
        Location location,
        String profilePicture,
        @JsonProperty("premium_access")
        Boolean premiumAccess
) {
}
