package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByName(String name);

}
