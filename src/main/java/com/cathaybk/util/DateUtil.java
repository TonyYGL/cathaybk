package com.cathaybk.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final DateTimeFormatter INPUT_FORMATTER =
            DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss z", Locale.ENGLISH);

    private static final DateTimeFormatter OUTPUT_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static Date parseToDate(String input) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(input, INPUT_FORMATTER);
        return Date.from(zonedDateTime.toInstant());
    }
}
