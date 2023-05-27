package com.example.vjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vjobs.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	
}

