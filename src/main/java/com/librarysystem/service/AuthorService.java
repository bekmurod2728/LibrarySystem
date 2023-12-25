package com.librarysystem.service;

import com.librarysystem.dto.AuthorDto;
import com.librarysystem.entity.Author;
import com.librarysystem.repasitory.AuthorRepository;
import com.librarysystem.repasitory.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(AuthorDto authorDto){
        Author author=new Author();
        author.setAge(author.getAge());
        author.setCitizenship(author.getCitizenship());
        author.setLast_name(author.getLast_name());
        author.setFirst_name(author.getFirst_name());
        authorRepository.save(author);
    }
}
