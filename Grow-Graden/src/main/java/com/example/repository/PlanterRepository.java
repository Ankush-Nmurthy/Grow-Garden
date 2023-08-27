package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Planter;

@Repository
public interface PlanterRepository extends JpaRepository<Planter, Integer>,PagingAndSortingRepository<Planter, Integer>{
	List<Planter> findByPlanterShape(String shape);
	List<Planter> findByplanterCostBetween(double min, double max);
}
