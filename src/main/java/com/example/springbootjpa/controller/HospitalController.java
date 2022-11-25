package com.example.springbootjpa.controller;


import com.example.springbootjpa.domain.Review;
import com.example.springbootjpa.model.dto.*;
import com.example.springbootjpa.service.HospitalService;
import com.example.springbootjpa.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService, HospitalService hospitalService) {
        this.reviewService = reviewService;
        this.hospitalService = hospitalService;
    }

    private final HospitalService hospitalService;



    @GetMapping("")
    public ResponseEntity<List<HospitalResponse>> getHospitals(Pageable pageable) {
        return ResponseEntity.ok().body(hospitalService.getHospitalList(pageable));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponse> addReview(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok().body(reviewService.addReview(id,reviewRequest));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getHospitalReviews(@PathVariable Long id){
        return ResponseEntity.ok().body(reviewService.getHospitalReviews(id));
    }
}
