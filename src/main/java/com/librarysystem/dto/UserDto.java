package com.librarysystem.dto;


import com.librarysystem.entity.UserData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    String username;
    String password;

    String last_name;
    String first_name;
    Integer age;
    String citizenship;
    String email;
    String role;


}
