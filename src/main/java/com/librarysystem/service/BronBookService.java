package com.librarysystem.service;


import com.librarysystem.dto.BronBookDto;
import com.librarysystem.entity.Book;
import com.librarysystem.entity.BronBook;
import com.librarysystem.repasitory.BookRepository;
import com.librarysystem.repasitory.BronBookRepository;
import com.librarysystem.repasitory.ManageLibraryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BronBookService {
    private final BronBookRepository bronBookRepository;
    private final BookRepository bookRepository;
    private final ManageLibraryRepository manageLibraryRepository;

    public BronBookService(BronBookRepository bronBookRepository, BookRepository bookRepository, ManageLibraryRepository manageLibraryRepository) {
        this.bronBookRepository = bronBookRepository;
        this.bookRepository = bookRepository;
        this.manageLibraryRepository = manageLibraryRepository;
    }

    public void addBronBook(BronBookDto bronBookDto){
        if (bronBookDto.getBook_id() != null){
            Optional<Book> byId = bookRepository.findById(bronBookDto.getBook_id());
            if (byId.isPresent()){
                BronBook bronBook=new BronBook();
                bronBook.setBook(byId.get());
                bronBook.setBronTime(LocalTime.now());
                bronBook.setDeadlineBronTime(bronBook.getBronTime().plusMinutes(5));
                bronBook.setIsBron(true);
                bronBookRepository.save(bronBook);
                byId.get().addBronBook(bronBook);
                bookRepository.save(byId.get());
            }
        }
    }
    @Scheduled(fixedRate = 60000) // 60000 milliseconds = 1 minute
    public void myScheduledTask() {
        List<BronBook> bronBooksByMinuteAndBookIs = bronBookRepository.getBronBooksByMinuteAndBookIs(LocalTime.now().getMinute(), true);
        Iterator<BronBook> iterator=bronBooksByMinuteAndBookIs.iterator();
        while (iterator.hasNext()){
            BronBook next = iterator.next();
            next.setIsBron(false);
            bronBookRepository.save(next);
        }
    }
}
