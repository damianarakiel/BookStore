package com.sda.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Book> bookSet;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
