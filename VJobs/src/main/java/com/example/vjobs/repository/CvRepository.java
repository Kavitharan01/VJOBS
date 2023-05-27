package com.example.vjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vjobs.model.Cv;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
}

