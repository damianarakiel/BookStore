package com.sda.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private String city;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> bookSet;

    public Publisher(String name, String adress, String city) {
        this.name = name;
        this.adress = adress;
        this.city = city;
    }

    public Publisher() {

    }
}
