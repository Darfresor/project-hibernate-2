package com.javarush.ostapenko.hibernate_2.domain.entity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)  // autoApply = true для автоматического применения
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null) {
            return null;
        }
        return rating.getDbValue();  // "NC-17", "PG-13" и т.д.
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Rating.fromDbValue(dbData);  // Используем ваш метод
    }
}