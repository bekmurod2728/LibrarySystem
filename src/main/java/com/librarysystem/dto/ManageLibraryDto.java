package com.librarysystem.dto;

import com.librarysystem.entity.BronBook;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManageLibraryDto {

    LocalDate borrow;
    LocalDate returnDate;
    Boolean isBorrow;


    Long bronBook_id;
}
