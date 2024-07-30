package org.Sem4HM.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public enum Holiday {
    NO_HOLIDAY("Сегодня тортика нет :(", null),
    NEW_YEAR("ШАМПАНСКОЕ НЕСИТЕ!!!", LocalDate.of(LocalDate.now().getYear(), 1, 1)),
    INTERNATIONAL_WOMENS_DAY("Мы бы уберли без вас, женщины", LocalDate.of(LocalDate.now().getYear(), 3, 8)),
    DEFENDERS_DAY("Скидываемся на пиво, мужики!", LocalDate.of(LocalDate.now().getYear(), 2, 23));

    private final String description;
    private final LocalDate date;

    public static Holiday getHolidayByDate(LocalDate date) {
        for (Holiday h : Holiday.values()) {
            if (h.getDate() != null && h.getDate().equals(date)) {
                return h;
            }
        }
        return NO_HOLIDAY;
    }
}
