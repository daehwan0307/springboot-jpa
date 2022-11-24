package com.example.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private Long id;
    private String name;
    private Long authorId; //authorname이 아니라 author id가 들어있다.
}
