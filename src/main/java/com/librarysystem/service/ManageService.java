package com.librarysystem.service;

import com.librarysystem.dto.ManageLibraryDto;
import com.librarysystem.entity.Book;
import com.librarysystem.entity.BronBook;
import com.librarysystem.entity.ManageLibrary;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.BronBookRepository;
import com.librarysystem.repasitory.ManageLibraryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ManageService {
    private final ManageLibraryRepository manageRepository;
    private final BookRepository bookRepository;

    public ManageService(ManageLibraryRepository manageRepository, BookRepository bookRepository) {
        this.manageRepository = manageRepository;
        this.bookRepository = bookRepository;
    }



    public List<ManageLibrary> show(){
        return manageRepository.findAll();
    }

    public void addBorrow(ManageLibraryDto manageLibraryDto){
        if (manageLibraryDto.getBook_id() != null){
            Optional<Book> byId = bookRepository.findById(manageLibraryDto.getBook_id());
            if (!byId.get().getBronBooks().isEmpty()&&
                    byId.get().getBronBooks().get(byId.get().getBronBooks().size()-1).getIsBron() == false
            && (byId.get().getManageLibraries().isEmpty() || byId.get().getManageLibraries().get(byId.get().getManageLibraries().size()-1).getIsBorrow() == false)){
                ManageLibrary manageLibrary=new ManageLibrary();
                manageLibrary.setBook(byId.get());
                manageLibrary.setBorrow(LocalTime.now());
                manageLibrary.setIsBorrow(true);
                manageLibrary.setReturnTime(LocalTime.now().plusMinutes(5));
                manageRepository.save(manageLibrary);
                byId.get().addManage(manageLibrary);
                bookRepository.save(byId.get());
            }
        }

    }

}
