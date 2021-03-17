package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Brand.Gender;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findByGender(Gender gender);
    Integer countByGender(Gender gender);
}