package com.tka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CategoryDao;
import com.tka.entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;

	public List<Category> getAllCategories() {

		return dao.findAll();
	}

	public String addCategory(Category category) {

		Optional<Category> name = dao.findById(category.getcId());

		if (name.isEmpty()) {

			dao.save(category);
			return "Category added";

		} else {

			return "Something went wrong";
		}
	}

	public Category getCatById(int cId) {

		Optional<Category> cat = dao.findById(cId);

		if (cat.isPresent()) {

			Category category = cat.get();

			return category;
		} else {

			return null;
		}
	}

	public String updateCategory(Category category) {

		Optional<Category> cat = dao.findById(category.getcId());

		if (cat.isPresent()) {

			Category newCat = new Category();

			newCat.setcId(category.getcId());
			newCat.setcName(category.getcName());
			newCat.setProducts(category.getProducts());

			dao.save(newCat);
			return "Categroy updated";

		} else {
			return "something is wrong";
		}
	}

	public String deleteCategory(int cId) {

		Optional<Category> cat = dao.findById(cId);

		if (cat.isPresent()) {

			dao.deleteById(cId);
			return "Category deleted";

		} else {
			return "something is wrong";
		}

	}

}
