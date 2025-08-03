package com.taskplanner.taskplanner.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class PriorityConverter implements AttributeConverter<Priority,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Priority attribute) {
        return attribute != null ? attribute.getCode() : null;
    }
    @Override
    public Priority convertToEntityAttribute(Integer dbData) {
        return dbData != null ? Priority.fromCode(dbData) : null;
    }
}
