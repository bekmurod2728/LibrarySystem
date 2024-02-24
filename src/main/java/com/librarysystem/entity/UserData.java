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
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String last_name;
    String first_name;
    Integer age;
    String citizenship;
    String email;
    @Enumerated(value = EnumType.STRING)
    ApplicationUserRole role;

    @OneToOne
    User user;

    @OneToMany(mappedBy = "userData")
    List<Book> books;

    public void addBook(Book book){
        if (books == null){
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
