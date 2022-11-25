package com.example.springbootjpa.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String patientName;
    private String hospitalName;
    private String message;
}
