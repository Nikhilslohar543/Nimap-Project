package com.tka.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tka.entity.Products;

@Repository
public interface ProductDao extends JpaRepository<Products, Integer>{
	
	@Query("SELECT p FROM Products p WHERE p.category.id = :categoryId")
	List<Products> getByCategory(@Param("categoryId") int categoryId);

}
