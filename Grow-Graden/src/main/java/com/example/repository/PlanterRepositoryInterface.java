package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Planter;

@Repository
public interface PlanterRepositoryInterface extends JpaRepository<Planter, Integer>{

}
