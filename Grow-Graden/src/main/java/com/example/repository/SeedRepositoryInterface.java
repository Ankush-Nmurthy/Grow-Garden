package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Seed;

@Repository
public interface SeedRepositoryInterface extends JpaRepository<Seed, Integer>{

}
