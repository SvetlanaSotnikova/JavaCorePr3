package org.Sem3HM.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatter {
    DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    default String formatDate(LocalDate date) {
        return date.format(DEFAULT_FORMATTER);
    }
}
