package com.librarysystem.controller;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.dto.KutubxonaDto;
import com.librarysystem.service.KutubxonaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kutubxona")
public class KutubxonaController {

    private final KutubxonaService kutubxonaService;

    public KutubxonaController(KutubxonaService kutubxonaService) {
        this.kutubxonaService = kutubxonaService;
    }

    @PostMapping("/add")
    public void addBookToKutubxona(@RequestBody KutubxonaDto kutubxonaDto){

        kutubxonaService.addBookToKutubxona(kutubxonaDto);
    }
}
