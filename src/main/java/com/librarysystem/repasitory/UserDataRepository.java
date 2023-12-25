package com.librarysystem.repasitory;

import com.librarysystem.entity.Author;
import com.librarysystem.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData,Long> {
}
