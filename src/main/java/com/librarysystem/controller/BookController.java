package com.librarysystem.controller;

import com.librarysystem.dto.BookDto;
import com.librarysystem.entity.Book;
import com.librarysystem.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/show")
    public ResponseEntity<List<Book>> getAll(){
        return bookService.getAll();
    }
    @PostMapping("/add")
    public void addBook(@RequestBody BookDto bookDto){
        bookService.addBooks(bookDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
