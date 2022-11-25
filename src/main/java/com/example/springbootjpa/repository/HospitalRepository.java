package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
