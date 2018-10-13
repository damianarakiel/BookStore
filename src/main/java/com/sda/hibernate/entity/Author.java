package com.sda.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String lastName;

    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> bookSet;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
