package com.mapping.onetoone.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String village;
    private String district;
}
