package com.example.springbootjpa.model.dto;

import com.example.springbootjpa.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateRequest {
    private Long hospitalId;
    private String userName;
    private String title;
    private String content;

    //public ReviewCreateResponse of(Hospital hospital,Review review)
}
