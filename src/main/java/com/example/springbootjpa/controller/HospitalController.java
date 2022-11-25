package com.example.springbootjpa.controller;


import com.example.springbootjpa.domain.Review;
import com.example.springbootjpa.model.dto.ReviewCreateRequest;
import com.example.springbootjpa.model.dto.ReviewCreateResponse;
import com.example.springbootjpa.model.dto.ReviewReadResponse;
import com.example.springbootjpa.service.ReviewService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest){
        log.info("{}",reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .hospitalName("병원이름 빈칸")
                .build();
        return ResponseEntity.ok().body(response);
    }
}
