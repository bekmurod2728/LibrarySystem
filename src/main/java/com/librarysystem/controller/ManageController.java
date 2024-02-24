package com.librarysystem.controller;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.dto.ManageLibraryDto;
import com.librarysystem.entity.BronBook;
import com.librarysystem.entity.ManageLibrary;
import com.librarysystem.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class ManageController {

    private final ManageService manageService;

    public ManageController(ManageService manageService) {
        this.manageService = manageService;
    }


//    @GetMapping("/bron_book_show")
//    public List<BronBook> getBronBooks(){
//        return manageService.getAll();
//    }
    @GetMapping("/borrow-book_show")
    public List<ManageLibrary> getBorrowBooks(){
        return manageService.show();
    }

    @PostMapping("/borrow")
    public void addBorrow(@RequestBody ManageLibraryDto managedto){
        manageService.addBorrow(managedto);
    }
}
