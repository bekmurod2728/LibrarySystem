package com.librarysystem.repasitory;

import com.librarysystem.entity.Author;
import com.librarysystem.entity.ManageLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageLibraryRepository extends JpaRepository<ManageLibrary,Long> {
}
