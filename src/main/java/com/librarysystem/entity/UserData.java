package com.librarysystem.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserData {
    @Id
    Long id;
    String last_name;
    String first_name;
    Integer age;
    String citizenship;
    String email;
    ApplicationUserRole role;

    @OneToOne
    User user;
}
