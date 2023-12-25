package com.librarysystem.controller;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/add")
    public void addAuthor(@RequestBody AuthorDto authorDto){
        authorService.addAuthor(authorDto);
    }
}
