package org.Sem4HM;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    MANAGER("Руководитель"),
    JUNIOR_DEVELOPER("Сырой разработчик"),
    MID_LEVEL_DEVELOPER("Прошаренный разработчик"),
    SENIOR_DEVELOPER("Пока что не пропил свои навыки разработчик"),
    TESTER("Тот кого никто не любит");

    private final String description;
}
