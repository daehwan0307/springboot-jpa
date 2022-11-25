package com.example.springbootjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateResponse {

    private String userName;
    private String title;
    private String content;
    private String message;
}
