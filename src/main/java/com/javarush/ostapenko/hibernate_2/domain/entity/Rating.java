package com.javarush.ostapenko.hibernate_2.domain.entity;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }
    public String getDbValue() {
        return value;
    }

    // Конвертер из строки БД в enum
    public static Rating fromDbValue(String value) {
        for (Rating rating : values()) {
            if (rating.value.equals(value)) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Unknown rating: " + value);
    }
}
