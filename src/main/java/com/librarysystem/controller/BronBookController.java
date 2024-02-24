package com.librarysystem.controller;

import com.librarysystem.dto.BookDto;
import com.librarysystem.dto.BronBookDto;
import com.librarysystem.entity.Book;
import com.librarysystem.service.BookService;
import com.librarysystem.service.BronBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bronbook")
public class BronBookController {
    private final BronBookService bronBookService;

    public BronBookController(BronBookService bronBookService) {
        this.bronBookService = bronBookService;
    }

//    @GetMapping("/show")
//    public ResponseEntity<List<Book>> getAll(){
//        return bookService.getAll();
//    }
    @PostMapping("/add")
    public void addBook(@RequestBody BronBookDto bronBookDto){
        bronBookService.addBronBook(bronBookDto);
    }
//    @DeleteMapping("/delete/{id}")
//    public void deleteById(@PathVariable Long id){
//        bookService.deleteById(id);
//    }
}
