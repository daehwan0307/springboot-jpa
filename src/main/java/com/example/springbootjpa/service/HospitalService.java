package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.Hospital;
import com.example.springbootjpa.model.dto.HospitalResponse;
import com.example.springbootjpa.repository.HospitalRepository;
import com.example.springbootjpa.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<HospitalResponse> getHospitalList(Pageable pageable){
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        List<HospitalResponse> hospitalResponses = hospitals.stream()
                .map(hospital -> HospitalResponse.of(hospital)).collect(Collectors.toList());
        return hospitalResponses;
    }

    public HospitalResponse getHospital(Long id){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = HospitalResponse.of(optionalHospital.get());
        return hospitalResponse;
    }




}
