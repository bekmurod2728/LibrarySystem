package com.librarysystem.controller;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.dto.UserDto;
import com.librarysystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addAuthor(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }
}
