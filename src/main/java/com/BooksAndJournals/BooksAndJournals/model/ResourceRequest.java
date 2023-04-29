package com.BooksAndJournals.BooksAndJournals.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResourceRequest {
    @NotEmpty(message = "The Resource Name Is Required ")
    @Size(min = 3,max = 15,message = "Please Make Sure To Insert Name Between 3 To 15 Digit ..")
    private String name;
    @Size(min = 1,max = 100,message = "Please Make Sure To Insert Name Between 1 To 100 Digit ..")
    private String description;
    @NotEmpty (message = "The Author Name Is Required")
    @Size(min = 3,max = 15,message = "Please Make Sure To Insert Name Between 3 To 15 Digit ..")
    private String author;
    @NotNull(message = "Availability can't be null")
    private boolean availability ;
    @NotEmpty(message = "The resource Type Is Required")
    private String resourceType;
}
