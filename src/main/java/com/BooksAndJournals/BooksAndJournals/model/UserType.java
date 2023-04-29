package com.BooksAndJournals.BooksAndJournals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum UserType {


        STUDENT("STUDENT"),FACILITY("FACILITY");

        private String value;

        @JsonCreator
        public static UserType fromValue(String value){
            for(UserType type : UserType.values()){
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


