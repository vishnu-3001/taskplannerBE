package com.taskplanner.taskplanner.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class StatusConverter implements AttributeConverter<Status,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute != null ? attribute.getCode() : null;
    }
    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return dbData != null ? Status.fromCode(dbData) : null;
    }
}
