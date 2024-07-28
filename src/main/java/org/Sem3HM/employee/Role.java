package org.Sem3HM.employee;

import lombok.Getter;

@Getter
public enum Role {
    MANAGER("Руководитель"),
    JUNIOR_DEVELOPER("Сырой разработчик"),
    MID_LEVEL_DEVELOPER("Прошаренный разработчик"),
    SENIOR_DEVELOPER("Пока что не пропил свои навыки разработчик"),
    TESTER("Тот кого никто не любит");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
