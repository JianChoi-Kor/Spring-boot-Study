package com.example.practice1.service;


import com.example.practice1.model.BookEntity;
import com.example.practice1.model.BookRequest;
import com.example.practice1.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public BookEntity add(BookRequest request) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(request.getTitle());
        bookEntity.setInfo(request.getInfo());
        bookEntity.setCompleted(request.getCompleted());

        return this.bookRepository.save(bookEntity);
    }

    public BookEntity searchById(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<BookEntity> searchAll() {
        return this.bookRepository.findAll();
    }

    public BookEntity updateById(Long id, BookRequest request) {
        BookEntity bookEntity = this.searchById(id);

        if(request.getTitle() != null) {
            bookEntity.setTitle(request.getTitle());
        }
        if(request.getInfo() != null) {
            bookEntity.setInfo(request.getInfo());
        }
        if(request.getCompleted() != null) {
            bookEntity.setCompleted(request.getCompleted());
        }

        return this.bookRepository.save(bookEntity);
    }

    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    public void deleteAll() {
        this.bookRepository.deleteAll();
    }


}




