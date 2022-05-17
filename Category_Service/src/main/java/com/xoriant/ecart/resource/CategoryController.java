package com.xoriant.ecart.resource;

import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save")
	public String addNewCategory(@RequestBody Category category) {
		categoryService.addNewCategory(category);
		String response = "New Category Added Succesfully !";
		return response;
	}

	@PostMapping("/saveAll")
	public String addNewListsOfCategory(@RequestBody List<Category> catLists) {
		categoryService.addNewListsOfCategory(catLists);
		String response = "New Lists of Category Added Succesfully !";
		return response;
	}

	@PutMapping("/update")
	public String updateCategory(@RequestBody Category category) {
		categoryService.updateExistingCategory(category);
		String response = "Updated Category Succesfully !";
		return response;
	}

	@PutMapping("/updateAll")
	public String updateListsOfCategory(@RequestBody List<Category> catLists) {
		categoryService.updateListsOfExistingCategory(catLists);
		String result = "Updated List Of Category Succesfully !";
		return result;
	}

	@GetMapping("/{categoryName}")
	public Optional<Category> findByCategoryName(@PathVariable String categoryName) {
		Optional<Category> category = categoryService.findByCategoryName(categoryName);
		return category;
	}

	@GetMapping("find/{categoryId}")
	public Optional<Category> findByCategoryId(@PathVariable int categoryId) {

		return categoryService.findByCategoryId(categoryId);
	}

	@GetMapping("/findAll")
	public List<Category> fetchAllCategoryBySotingOrderByCategoryId() {

		return categoryService.fetchAllCategoryBySotingOrderByCategoryId();
	}

	@GetMapping("/findAll/sorted")
	public List<Category> fetchCategoryListsBasedOnAlphabeticalOrder() {
		return categoryService.fetchCategoryListsBasedOnAlphabeticalOrder();
	}

	@GetMapping("/find/brand/{brandId}")
	Optional<Brand> findById(@PathVariable int brandId) {

		return categoryService.findById(brandId);
	}

	@GetMapping("/brand-lists")
	public List<Brand> fetchAll() {
		return categoryService.fetchAll();
	}

	@GetMapping("brand-sorted/fetchAll")
	public List<Brand> fetchAllAlphabeticalOrder() {
		return categoryService.fetchAllAlphabeticalOrder();
	}

	@PostMapping("api/product/save")
	public String addNewProduct(@RequestBody Product product) {
		return categoryService.addNewProduct(product);
	}

	@PostMapping("api/product/saveAll")
	List<Product> addNewListofProduct(@RequestBody List<Product> prodLists) {
		return categoryService.addNewListofProduct(prodLists);
	}

	@PutMapping("api/product/update")
	Product updateProduct(@RequestBody Product product) {
		return categoryService.updateProduct(product);
	}

	@PutMapping("api/product/updateAll")
	List<Product> updateProductLists(@RequestBody List<Product> prodLists) {
		return categoryService.updateProductLists(prodLists);
	}

	@GetMapping("api/product/{productId}")
	Optional<Product> findByProductId(@PathVariable int productId) {
		return categoryService.findByProductId(productId);
	}

	@GetMapping("api/product/find/{productName}")
	Optional<Product> findByProductName(@PathVariable String productName) {
		return categoryService.findByProductName(productName);
	}

	@GetMapping("api/product/findAll")
	List<Product> fetchAllProducts() {
		return categoryService.fetchProductsAll();
	}

	@GetMapping("api/product/findAll/sorted")
	List<Product> fetchByAlphabeticalOrder() {
		return categoryService.fetchByAlphabeticalOrder();
	}

	@DeleteMapping("api/product/{productId}")
	void deleteProduct(@PathVariable int productId) {
		categoryService.deleteProduct(productId);
	}

	@GetMapping("api/product/minPrice/{minPrice}")
	List<Product> findByPriceLessThan(@PathVariable double minPrice) {
		return categoryService.findByPriceLessThan(minPrice);
	}

	@GetMapping("api/product/find/price/{maxPrice}")
	List<Product> findByPriceGreaterThan(@PathVariable double maxPrice) {
		return categoryService.findByPriceGreaterThan(maxPrice);
	}

	@GetMapping("api/product/find/{minPrice}/{maxPrice}")
	List<Product> findByPriceIsBetween(@PathVariable double minPrice, @PathVariable double maxPrice) {
		return categoryService.findByPriceIsBetween(minPrice, maxPrice);
	}
}
