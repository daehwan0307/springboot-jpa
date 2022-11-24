package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.Author;
import com.example.springbootjpa.domain.Book;
import com.example.springbootjpa.model.dto.BookResponse;
import com.example.springbootjpa.repository.AuthorRepository;
import com.example.springbootjpa.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book->{
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());  //book에 들어있는 authorid로 검색을 한결과를 optionalAuthor에 저장
                    return BookResponse.of(book,optionalAuthor.get().getName());  //optionalAuthor.get().getName()을 통하여 String authorname을 받아온다.
                }).collect(Collectors.toList());  //bookResponse의 return type이 List이기 때문에 mapping한 값들을 list로 만들어서 반환해줘야 한다.
        //collect메소드 toList(), toSet() 등등 존재

        return bookResponses;
    }


}
