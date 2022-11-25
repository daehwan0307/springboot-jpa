package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.Hospital;
import com.example.springbootjpa.domain.Review;
import com.example.springbootjpa.model.dto.ReviewCreateRequest;
import com.example.springbootjpa.model.dto.ReviewCreateResponse;
import com.example.springbootjpa.repository.HospitalRepository;
import com.example.springbootjpa.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest dto){
        //Hospital 불러오기
        Optional<Hospital> hospitalOptional =hospitalRepository.findById(dto.getHospitalId());

       //ReviewEntity만들기
        Review review = Review.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .patientName(dto.getUserName())
                        .hospital(hospitalOptional.get())
                        .build();

        //저장
        Review savedReview = reviewRepository.save(review);
        return  ReviewCreateResponse.builder()
                .userName(savedReview.getPatientName())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .message("리뷰 등록이 성공했습니다.")
                .build();
    }
}
