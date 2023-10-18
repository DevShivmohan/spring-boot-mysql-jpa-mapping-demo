package com.mapping.manytoone.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Address address;
}
