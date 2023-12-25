package com.librarysystem.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManageLibrary {
    @Id
    Long id;
    LocalDate borrow;
    LocalDate returnDate;
    Boolean isBorrow;

    @OneToOne
    Book book;

    @OneToOne
    BronBook bronBook;
}
