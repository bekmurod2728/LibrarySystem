package com.librarysystem.repasitory;

import com.librarysystem.entity.Book;
import com.librarysystem.entity.BronBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BronBookRepository extends JpaRepository<BronBook,Long> {
    @Query("SELECT b FROM BronBook b WHERE EXTRACT(MINUTE FROM b.deadlineBronTime) = :minuteParam AND b.isBron = :bookIsParam")
    List<BronBook> getBronBooksByMinuteAndBookIs(@Param("minuteParam") int minuteParam, @Param("bookIsParam") boolean bookIsParam);
}
