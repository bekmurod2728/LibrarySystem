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
public class Book {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String bookName;
    Integer bookPage;
    @ManyToMany(mappedBy = "books")
    List<Genre> genres;

    @ManyToOne
    Author author;

    @ManyToOne
    Kutubxona kutubxona;

    @OneToOne
    BronBook bronBook;

    @OneToOne
    ManageLibrary manageLibraries;

    public void addGenre(Genre genre){
        if (genres==null){
            genres=new ArrayList<>();
        }
        genres.add(genre);
    }
}
