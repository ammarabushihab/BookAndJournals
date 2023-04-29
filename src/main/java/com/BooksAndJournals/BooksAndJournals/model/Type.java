package com.BooksAndJournals.BooksAndJournals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum Type {
    BOOK("BOOK"),JOURNAL("JOURNAL");

    private String value;

    @JsonCreator
    public static Type fromValue(String value){
        for(Type type : Type.values()){
            if(type.getValue().equals(value)){
                return type;
            }
        }
        throw new IllegalArgumentException();
    }

    @JsonValue
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
