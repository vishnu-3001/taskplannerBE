package com.taskplanner.taskplanner.model;
import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply=false)
public class StringConverter implements AttributeConverter<List<String>,String> {
    private static final ObjectMapper mapper=new ObjectMapper();
    private static final TypeReference<List<String>> typeref=new TypeReference<>() {};

    @Override
    public String convertToDatabaseColumn(List<String>list){
        try{
            return list==null?"[]":mapper.writeValueAsString(list);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Error converting list to json",e);
        }
    }
    @Override
    public List<String>convertToEntityAttribute(String s){
        try{
            return (s==null||s.isBlank())?new ArrayList<>():new ArrayList<>(mapper.readValue(s,typeref));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Error converting json to list",e);
        }
    }
    
}
