package com.BooksAndJournals.BooksAndJournals.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userId;
    private  String userName ;
    private String  userEmail;
    private UserType userType;
    @OneToMany(mappedBy="borrowingBy")
    private Set<Resource> resources=new HashSet<>();


}
