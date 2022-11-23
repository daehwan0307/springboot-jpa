package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.Book;
import com.example.springbootjpa.model.dto.BookResponse;
import com.example.springbootjpa.service.BookService;
import lombok.Getter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable){
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id){
        return ResponseEntity.ok().body(new Book());
    }


}
