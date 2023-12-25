package com.librarysystem.repasitory;

import com.librarysystem.entity.Book;
import com.librarysystem.entity.Kutubxona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KutubxonaRepository extends JpaRepository<Kutubxona,Long> {
}
