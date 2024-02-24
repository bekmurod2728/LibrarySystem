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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bookName;
    Integer bookPage;
    @ManyToMany(mappedBy = "books")
    List<Genre> genres;

    @ManyToOne
    Author author;

    @ManyToOne
    Kutubxona kutubxona;

    @OneToMany(mappedBy = "book")
    List<BronBook> bronBooks;

    @OneToMany(mappedBy = "book")
    List<ManageLibrary> manageLibraries;

    @ManyToOne
    UserData userData;



    public void addManage(ManageLibrary manageLibrary) {
        if (manageLibraries == null) {
            manageLibraries = new ArrayList<>();
        }
        manageLibraries.add(manageLibrary);
    }
    public void addBronBook(BronBook bronBook) {
        if (bronBooks == null) {
            bronBooks = new ArrayList<>();
        }
        bronBooks.add(bronBook);
    }
    public void addGenre(Genre genre) {
        if (genres == null) {
            genres = new ArrayList<>();
        }
        genres.add(genre);
    }
}
