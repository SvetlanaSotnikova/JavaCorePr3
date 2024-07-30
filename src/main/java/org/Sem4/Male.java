package org.Sem4;

import lombok.Getter;

@Getter
public enum Male {
    MALE("мальчик"),
    FEMALE("девочка");
    private final String ruMaleTitle;

    Male(String ruMaleTitle) {
        this.ruMaleTitle = ruMaleTitle;
    }

}
