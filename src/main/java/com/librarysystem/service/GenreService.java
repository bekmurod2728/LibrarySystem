package com.librarysystem.service;

import com.librarysystem.dto.GenreDto;
import com.librarysystem.entity.Book;
import com.librarysystem.entity.Genre;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    public GenreService(GenreRepository genreRepository, BookRepository bookRepository) {
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    public void addGenre(GenreDto genreDto){
        Optional<Book> byId = bookRepository.findById(genreDto.getBook_id());
        if (byId.isPresent()){
            Book book = byId.get();
            Genre genre=new Genre();
            genre.setGenreName(genreDto.getGenreName());
            genre.addBook(book);
            book.addGenre(genre);
            bookRepository.save(book);
            genreRepository.save(genre);
        }
        Genre genre=new Genre();
        genre.setGenreName(genreDto.getGenreName());
        genreRepository.save(genre);
    }
}
