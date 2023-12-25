package com.librarysystem.repasitory;

import com.librarysystem.entity.Book;
import com.librarysystem.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
