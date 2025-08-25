package com.taskplanner.taskplanner.model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import java.util.*;

@Converter(autoApply = false)
public class ChecklistConverter implements AttributeConverter<List<Checklist>,String> {
    private static final ObjectMapper mapper=new ObjectMapper();
    private static final TypeReference<List<Checklist>> typeref = new TypeReference<>() {};
    @Override
    public String convertToDatabaseColumn(List<Checklist>list){
        try{
            return list==null?"[]":mapper.writeValueAsString(list);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Error converting checklist to json",e);
        }
    }
    @Override
    public List<Checklist> convertToEntityAttribute(String s){
        try{
            return (s==null||s.isBlank())?new ArrayList<>():new ArrayList<>(mapper.readValue(s,typeref));
        }
        catch(Exception e){
            throw new IllegalArgumentException("Error converting json to checklist",e);
        }
    }
    
}
