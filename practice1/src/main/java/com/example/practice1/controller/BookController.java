package com.example.practice1.controller;


import com.example.practice1.model.BookEntity;
import com.example.practice1.model.BookRequest;
import com.example.practice1.model.BookResponse;
import com.example.practice1.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/")
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<BookResponse> addBookData(@RequestBody BookRequest request) {
        System.out.println("addBookData");

        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getInfo()))
            request.setInfo("Book Info");

        if(ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        BookEntity result = this.service.add(request);
        return ResponseEntity.ok(new BookResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getBookData(@PathVariable Long id) {
        System.out.println("getBookData");
        BookEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new BookResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBookList() {
        System.out.println("getBookList");
        List<BookEntity> list = this.service.searchAll();
        List<BookResponse> response = list.stream().map(BookResponse::new)
                                                    .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<BookResponse> updateBookData(@PathVariable Long id, @RequestBody BookRequest request) {
        System.out.println("updateBookData");
        BookEntity result = this.service.updateById(id, request);
        return ResponseEntity.ok(new BookResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBookData(@PathVariable Long id) {
        System.out.println("deleteBookData");
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("deleteAll");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }


}
