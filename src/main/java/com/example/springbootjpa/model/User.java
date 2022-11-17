package com.example.springbootjpa.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}

