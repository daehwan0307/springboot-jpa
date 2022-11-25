package com.example.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private Long id;
    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospitalId; //hospital이랑 mapping하기 위해서
}
