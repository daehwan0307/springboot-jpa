package com.example.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    private Long id;
    private String hospitalName;
    private String roadNameAddress;

    @OneToMany(mappedBy = "hospital",fetch = FetchType.LAZY) //병원입장에서 병원이1개 리뷰는 여러개 가능하다
    private List<Review> reviews;
}
