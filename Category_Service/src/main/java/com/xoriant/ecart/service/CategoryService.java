package com.xoriant.ecart.service;

import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.model.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryService {

	Category addNewCategory(Category category);

	List<Category> addNewListsOfCategory(List<Category> category);

	Category updateExistingCategory(Category category);

	List<Category> updateListsOfExistingCategory(List<Category> catLists);

	Optional<Category> findByCategoryName(String categoryName);

	Optional<Category> findByCategoryId(int categoryId);

	List<Category> fetchAllCategoryBySotingOrderByCategoryId();

	List<Category> fetchCategoryListsBasedOnAlphabeticalOrder();

	Optional<Brand> findById(int brandId);

	List<Brand> fetchAll();

	List<Brand> fetchAllAlphabeticalOrder();

	public String addNewProduct(Product product);

	List<Product> addNewListofProduct(List<Product> prodLists);

	Product updateProduct(Product product);

	List<Product> updateProductLists(List<Product> prodLists);

	Optional<Product> findByProductId(int productId);

	Optional<Product> findByProductName(String productName);

	List<Product> fetchProductsAll();

	List<Product> fetchByAlphabeticalOrder();

	void deleteProduct(int productId);

	List<Product> findByPriceLessThan(double minPrice);

	List<Product> findByPriceGreaterThan(double maxPrice);

	List<Product> findByPriceIsBetween(double minPrice, double maxPrice);

}
