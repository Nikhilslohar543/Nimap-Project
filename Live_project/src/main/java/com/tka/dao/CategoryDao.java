package com.tka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

	
}
