package com.librarysystem.service;

import com.librarysystem.dto.KutubxonaDto;
import com.librarysystem.entity.Book;
import com.librarysystem.entity.Kutubxona;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.KutubxonaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KutubxonaService {
    private final KutubxonaRepository kutubxonaRepository;
    private final BookRepository bookRepository;

    public KutubxonaService(KutubxonaRepository kutubxonaRepository, BookRepository bookRepository) {
        this.kutubxonaRepository = kutubxonaRepository;
        this.bookRepository = bookRepository;
    }
    public void addBookToKutubxona(KutubxonaDto kutubxonaDto){
            Kutubxona kutubxona=new Kutubxona();
            kutubxona.setBookcase(kutubxonaDto.getBookcase());
            kutubxona.setRow(kutubxonaDto.getRow());
            kutubxona.setShelf(kutubxonaDto.getShelf());
            kutubxona.setFloor(kutubxonaDto.getFloor());
            kutubxonaRepository.save(kutubxona);
    }
}
