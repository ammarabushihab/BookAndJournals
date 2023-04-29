package com.BooksAndJournals.BooksAndJournals.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserRequest {
    @NotEmpty(message = "The User Name Is Required ")
    @Size(min = 3,max = 15,message = "Please Make Sure To Insert Name Between 3 To 15 Digit ..")
    private  String userName ;
    @Email
    private String  userEmail;
    @NotEmpty(message = "The User Type Name Should be {STUDENT,FACILITY}")
    private String userType;
}
