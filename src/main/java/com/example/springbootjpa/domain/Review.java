package com.example.springbootjpa.domain;

import com.example.springbootjpa.model.dto.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital; //hospital이랑 mapping하기 위해서

    public ReviewResponse of() {
        return ReviewResponse.builder()
                .id(this.id)
                .hospitalName(this.hospital.getHospitalName())
                .patientName(this.patientName)
                .title(this.title)
                .content(this.content)
                .build();
    }
}
