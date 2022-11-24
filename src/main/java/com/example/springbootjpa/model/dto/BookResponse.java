package com.example.springbootjpa.model.dto;


import com.example.springbootjpa.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder  //객체생성 annotation
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long bookId;
    private String bookName;
    private String authorName;  //책, 책이름, 저자이름으로 response를 받아야 한다. 기존 -book, author 말고 새로운 reponse를 만듬


    public static BookResponse of(Book book, String authorName){  //of함수를 사용하여 BookResponse객체를 생성한다.
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .authorName(authorName)
                .build();
    }
}
