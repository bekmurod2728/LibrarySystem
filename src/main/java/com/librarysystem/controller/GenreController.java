package com.librarysystem.controller;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.dto.GenreDto;
import com.librarysystem.service.GenreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/add")
    public void addGenre(@RequestBody GenreDto genreDto){
        genreService.addGenre(genreDto);
    }
}
