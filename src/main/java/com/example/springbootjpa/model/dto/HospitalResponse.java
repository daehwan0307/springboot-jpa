package com.example.springbootjpa.model.dto;

import com.example.springbootjpa.domain.Hospital;
import com.example.springbootjpa.domain.Review;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
    private List<Review> reviews;

    public static HospitalResponse of (Hospital hospital) {
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews())
                .build();
    }
}
