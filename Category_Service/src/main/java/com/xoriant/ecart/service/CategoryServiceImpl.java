package com.xoriant.ecart.service;

import com.xoriant.ecart.dao.CategoryDao;
import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.exception.ElementNotFoundException;
import com.xoriant.ecart.exception.UserInputException;
import com.xoriant.ecart.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	BrandServiceProxy brandServiceProxy;

	@Autowired
	ProductServiceProxy productServiceProxy;

	@Override
	public Category addNewCategory(Category category) {
		if (category.getCategoryName().isBlank() || category.getCategoryName().isBlank()
				|| category.getCategoryName().length() == 0) {
			throw new UserInputException();
		}
		Category newAddedCategory = categoryDao.save(category);
		return newAddedCategory;
	}

	@Override
	public List<Category> addNewListsOfCategory(List<Category> category) {
		for (Category newCategory : category) {
			if (newCategory.getCategoryName().isBlank() || newCategory.getCategoryName().isBlank()
					|| newCategory.getCategoryName().length() == 0) {
				throw new UserInputException();
			}
		}
		List<Category> newCategoryLists = categoryDao.saveAll(category);
		return newCategoryLists;
	}

	@Override
	public Category updateExistingCategory(Category category) {

		Optional<Category> checkExistingCategory = categoryDao.findById(category.getCategoryId());
		if (!checkExistingCategory.isPresent()) {
			throw new ElementNotFoundException();
		}
		if (category.getCategoryName().isBlank() || category.getCategoryName().isBlank()
				|| category.getCategoryName().length() == 0) {
			throw new UserInputException();
		}
		Category existingCategory = categoryDao.findById(category.getCategoryId()).orElse(null);
		existingCategory.setCategoryId(category.getCategoryId());
		existingCategory.setCategoryName(category.getCategoryName());
		categoryDao.save(existingCategory);

		return category;
	}

	@Override
	public List<Category> updateListsOfExistingCategory(List<Category> catLists) {
		List<Category> updatedCategoryLists = new ArrayList<>();
		for (Category isExistCategory : catLists) {
			Optional<Category> category = categoryDao.findById(isExistCategory.getCategoryId());
			if (!category.isPresent()) {
				throw new ElementNotFoundException();
			}
			if (isExistCategory.getCategoryName().isBlank() || isExistCategory.getCategoryName().isBlank()
					|| isExistCategory.getCategoryName().length() == 0) {
				throw new UserInputException();
			}
		}

		for (Category updateExistCat : catLists) {
			Category category = categoryDao.findById(updateExistCat.getCategoryId()).orElse(null);
			category.setCategoryId(updateExistCat.getCategoryId());
			category.setCategoryName(updateExistCat.getCategoryName());
			categoryDao.save(updateExistCat);
			updatedCategoryLists.add(category);
		}
		return updatedCategoryLists;
	}

	@Override
	public Optional<Category> findByCategoryName(String categoryName) {
		Optional<Category> isExistCategory = categoryDao.findByCategoryName(categoryName);
		if (!isExistCategory.isPresent()) {
			throw new ElementNotFoundException();
		}
		return isExistCategory;
	}

	@Override
	public Optional<Category> findByCategoryId(int categoryId) {
		Optional<Category> isExistCategory = categoryDao.findById(categoryId);
		if (!isExistCategory.isPresent()) {
			throw new ElementNotFoundException();
		}
		return isExistCategory;
	}

	@Override
	public List<Category> fetchAllCategoryBySotingOrderByCategoryId() {
		List<Category> isExistCategory = categoryDao.findAll();
		if (isExistCategory == null) {
			throw new ElementNotFoundException();
		}
		return isExistCategory;
	}

	@Override
	public List<Category> fetchCategoryListsBasedOnAlphabeticalOrder() {
		List<Category> isExistCategory = categoryDao.findAll();
		if (isExistCategory == null) {
			throw new ElementNotFoundException();
		}
		List<Category> sortedList = isExistCategory.stream()
				.sorted((o1, o2) -> o1.getCategoryName().compareTo(o2.getCategoryName())).collect(Collectors.toList());

		return sortedList;
	}

	@Override
	public Optional<Brand> findById(int brandId) {

		return brandServiceProxy.findById(brandId);

	}

	@Override
	public List<Brand> fetchAll() {
		return brandServiceProxy.fetchAll();
	}

	@Override
	public List<Brand> fetchAllAlphabeticalOrder() {
		return brandServiceProxy.fetchAllAlphabeticalOrder();
	}

	@Override
	public String addNewProduct(Product product) {

		return productServiceProxy.addNewProduct(product);
	}

	@Override
	public List<Product> addNewListofProduct(List<Product> prodLists) {
		return productServiceProxy.addNewListofProduct(prodLists);
	}

	@Override
	public Product updateProduct(Product product) {

		return productServiceProxy.updateProduct(product);
	}

	@Override
	public List<Product> updateProductLists(List<Product> prodLists) {
		return productServiceProxy.updateProductLists(prodLists);
	}

	@Override
	public Optional<Product> findByProductId(int productId) {
		return productServiceProxy.findById(productId);
	}

	@Override
	public Optional<Product> findByProductName(String productName) {
		return productServiceProxy.findByProductName(productName);
	}

	@Override
	public List<Product> fetchProductsAll() {
		return productServiceProxy.fetchAll();
	}

	@Override
	public List<Product> fetchByAlphabeticalOrder() {
		return productServiceProxy.fetchByAlphabeticalOrder();
	}

	@Override
	public void deleteProduct(int productId) {
		productServiceProxy.deleteProduct(productId);
	}

	@Override
	public List<Product> findByPriceLessThan(double minPrice) {
		return productServiceProxy.findByPriceLessThan(minPrice);
	}

	@Override
	public List<Product> findByPriceGreaterThan(double maxPrice) {
		return productServiceProxy.findByPriceGreaterThan(maxPrice);
	}

	@Override
	public List<Product> findByPriceIsBetween(double minPrice, double maxPrice) {
		return productServiceProxy.findByPriceIsBetween(minPrice, maxPrice);
	}
}
