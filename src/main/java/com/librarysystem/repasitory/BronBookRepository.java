package com.librarysystem.repasitory;

import com.librarysystem.entity.Book;
import com.librarysystem.entity.BronBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BronBookRepository extends JpaRepository<BronBook,Long> {
}
