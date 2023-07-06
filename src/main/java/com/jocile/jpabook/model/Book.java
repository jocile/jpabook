package com.jocile.jpabook.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;

    public Book() {
        id = -1;
        title = "";
        author = "";
    }

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    public Book(String title) {
        id = -1;
        this.title = title;
        author = "";
    }
    
    public Book(String title, String author) {
        id = -1;
        this.title = title;
        this.author = author;
    }
}
