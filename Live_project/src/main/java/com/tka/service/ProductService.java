package com.tka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CategoryDao;
import com.tka.dao.ProductDao;
import com.tka.entity.Category;
import com.tka.entity.Products;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	@Autowired
	CategoryDao cdao;

	public List<Products> getAllProducts(int cId) {

		Optional<Category> cat = cdao.findById(cId);

		if (cat.isPresent()) {
			return dao.getByCategory(cId);
		} else {
			return null;
		}

	}

	public Products getProductById(int pId) {

		Optional<Products> pro = dao.findById(pId);

		if (pro.isPresent()) {
			Products product = pro.get();
			return product;
		} else {
			return null;
		}
	}

	public String addProduct(int cId, Products product) {

		Optional<Category> cat = cdao.findById(cId);

		if (cat.isPresent()) {

			Category c = cat.get();

			Optional<Products> pro = dao.findById(product.getpId());

			if (pro.isEmpty()) {
				product.setCategory(c);
				dao.save(product);
				return "new product added";
			} else {
				return "something went wrong";
			}
		} else {
			return null;
		}
	}

	public String updateProduct(int cId, Products product) {

		Optional<Category> cat = cdao.findById(cId);

		if (cat.isPresent()) {

			Category category = cat.get();

			Optional<Products> pro = dao.findById(product.getpId());

			if (pro.isPresent()) {

				Products newPro = new Products();

				newPro.setpId(product.getpId());
				newPro.setpName(product.getpName());
				newPro.setPrice(product.getPrice());
				newPro.setCategory(category);

				dao.save(newPro);

				return "product updated";

			} else {
				return "something is wrong";
			}
		} else {
			return "category not found";
		}

	}

	public String deleteProduct(int pId) {

		Optional<Products> p = dao.findById(pId);

		Products pro = p.get();

		if (pro != null) {
			dao.delete(pro);
			return "product deleted";

		} else {

			return "something is wrong";
		}
	}

}
