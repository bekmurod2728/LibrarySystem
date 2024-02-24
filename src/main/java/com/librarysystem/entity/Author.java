package com.librarysystem.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String first_name;
    String last_name;
    Integer age;
    String citizenship;
    @OneToMany(mappedBy = "author")
    List<Book> books;

    public  void addBooks(Book book){
        if (books ==null){
            books=new ArrayList<>();
        }
        books.add(book);
    }
}
