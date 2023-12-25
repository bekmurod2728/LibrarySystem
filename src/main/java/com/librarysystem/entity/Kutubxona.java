package com.librarysystem.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Kutubxona {
    @Id
    Long id;
    Integer floor;
    Integer bookcase;
    Integer shelf;
    Integer row;

    @OneToMany(mappedBy = "kutubxona")
    List<Book> books;
}
