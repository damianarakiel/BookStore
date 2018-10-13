package com.sda.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authorSet;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book() {
    }
}
