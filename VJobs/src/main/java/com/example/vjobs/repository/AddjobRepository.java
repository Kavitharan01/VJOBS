package com.example.vjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vjobs.model.Addjob;

@Repository
public interface AddjobRepository extends JpaRepository<Addjob, Long>{

}
