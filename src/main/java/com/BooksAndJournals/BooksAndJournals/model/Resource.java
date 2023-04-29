package com.BooksAndJournals.BooksAndJournals.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "RESOURCE")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "RESOURCE_NAME")
    private String name;
    @Column(name = "RESOURCE_DESCRIPTION")
    private String description;
    @Column(name = "RESOURCE_AUTHOR")
    private String author;
    @Column(name = "RESOURCE_AVAILABILITY")
    private boolean availability ;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "RESOURCE_TYPE")
    private Type resourceType;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User borrowingBy;
}
