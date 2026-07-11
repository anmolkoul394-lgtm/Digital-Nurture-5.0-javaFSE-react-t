package com.dn5.week3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Module 7 -> "RESTful CRUD Operations" subtopic:
 * @Version enables OPTIMISTIC LOCKING for concurrent updates — if two
 * clients PUT the same book at once, the second write fails with a
 * validation error instead of silently overwriting the first.
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer stock;

    @Version
    private Long version;
}
