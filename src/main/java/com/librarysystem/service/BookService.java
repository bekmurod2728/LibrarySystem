package com.librarysystem.service;

import com.librarysystem.dto.BookDto;
import com.librarysystem.entity.Author;
import com.librarysystem.entity.Book;
import com.librarysystem.entity.Genre;
import com.librarysystem.entity.Kutubxona;
import com.librarysystem.repasitory.AuthorRepository;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.GenreRepository;
import com.librarysystem.repasitory.KutubxonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final KutubxonaRepository kutubxonaRepository;
    private final GenreRepository genreRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       KutubxonaRepository kutubxonaRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.kutubxonaRepository = kutubxonaRepository;
        this.genreRepository = genreRepository;
    }

    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public void addBooks(BookDto bookDto){
        Optional<Author> byId = authorRepository.findById(bookDto.getAuthor_id());
        Optional<Kutubxona> byId1 = kutubxonaRepository.findById(bookDto.getKutubxona_id());
        Optional<Genre> byId2 = genreRepository.findById(bookDto.getGenre_id());
        if (byId.isPresent() && byId1.isPresent()&& byId2.isPresent()){
            Author author = byId.get();
            Kutubxona kutubxona = byId1.get();
            Genre genre = byId2.get();
            Book book=new Book();
            book.setBookPage(bookDto.getBookPage());
            book.setBookName(bookDto.getBookName());
            book.setAuthor(author);
            book.setKutubxona(kutubxona);
            book.addGenre(genre);
            bookRepository.save(book);
            kutubxonaRepository.save(kutubxona);
            authorRepository.save(author);
            genreRepository.save(genre);
        }
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }



}
