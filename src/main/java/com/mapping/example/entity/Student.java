package com.mapping.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String department;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<StudentBooks> studentBooks;
}
