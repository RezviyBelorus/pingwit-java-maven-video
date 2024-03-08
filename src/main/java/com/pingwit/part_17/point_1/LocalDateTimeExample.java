package com.pingwit.part_17.point_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.atStartOfDay());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds.size());
        System.out.println(availableZoneIds);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedLocalDate = LocalDate.parse("10-11-1999", dtf);
        System.out.println(parsedLocalDate);
        System.out.println(dtf.format(parsedLocalDate));

        DateTimeFormatter toStringLocalDateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println(toStringLocalDateFormatter.format(parsedLocalDate));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("10-November-1999 12:54:01", dateTimeFormatter);
        System.out.println(parsedLocalDateTime);
        System.out.println(parsedLocalDateTime.getDayOfYear());
    }
}
