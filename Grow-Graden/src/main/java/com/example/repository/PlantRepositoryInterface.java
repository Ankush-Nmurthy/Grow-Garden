package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Plant;

@Repository
public interface PlantRepositoryInterface extends JpaRepository<Plant, Integer>{
	
}
