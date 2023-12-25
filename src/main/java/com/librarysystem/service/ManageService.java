package com.librarysystem.service;

import com.librarysystem.entity.Book;
import com.librarysystem.entity.BronBook;
import com.librarysystem.entity.ManageLibrary;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.BronBookRepository;
import com.librarysystem.repasitory.ManageLibraryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ManageService {
    private final BronBookRepository bronBookRepository;
    private final ManageLibraryRepository manageRepository;
    private final BookRepository bookRepository;

    public ManageService(BronBookRepository bronBookRepository,
                         ManageLibraryRepository manageRepository, BookRepository bookRepository) {
        this.bronBookRepository = bronBookRepository;
        this.manageRepository = manageRepository;
        this.bookRepository = bookRepository;
    }

    public String bronBooks(Long book_id){
        Optional<Book> byId = bookRepository.findById(book_id);
        if (byId.isPresent() && !byId.get().getBronBook().getIsBron()){
            BronBook bronBook=new BronBook();
            bronBook.setBronDate(LocalDate.now());
            bronBook.setBook(byId.get());
            bronBook.setIsBron(true);
            bronBookRepository.save(bronBook);
            return "Siz tanlagan kitob bron qilindi.";
        }
        return "bu kitob boshqa foydalonuchi tomonidan bron qilingan";
    }

    public List<BronBook> getAll(){
        return bronBookRepository.findAll();
    }

    public List<ManageLibrary> show(){
        return manageRepository.findAll();
    }

    public void addBorrow(Long book_id){
        Optional<Book> byId = bookRepository.findById(book_id);
        if (byId.isPresent()&&!byId.get().getBronBook().getIsBron()&& !byId.get().getManageLibraries().getIsBorrow()){
            ManageLibrary manageLibrary=new ManageLibrary();
            manageLibrary.setBook(byId.get());
            manageLibrary.setBorrow(LocalDate.now());
            manageLibrary.setIsBorrow(true);
            manageLibrary.setReturnDate(LocalDate.now().plusDays(30));
            manageRepository.save(manageLibrary);
            bookRepository.save(byId.get());
        }
    }

}
