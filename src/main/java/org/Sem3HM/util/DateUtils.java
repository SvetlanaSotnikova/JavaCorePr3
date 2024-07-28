package org.Sem3HM.util;

import org.Sem3HM.impl.DateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils implements DateFormatter {
    public static int compareDates(String date1Str, String date2Str) {
        DateTimeFormatter formatter = DateFormatter.DEFAULT_FORMATTER;
        LocalDate date1 = LocalDate.parse(date1Str, formatter);
        LocalDate date2 = LocalDate.parse(date2Str, formatter);
        return date1.compareTo(date2);
    }
}
