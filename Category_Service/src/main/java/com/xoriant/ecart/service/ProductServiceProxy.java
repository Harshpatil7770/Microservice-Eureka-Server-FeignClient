package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.ecart.dto.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@PostMapping("api/product/save")
	public String addNewProduct(@RequestBody Product product);

	@PostMapping("api/product/saveAll")
	List<Product> addNewListofProduct(@RequestBody List<Product> prodLists);

	@PutMapping("api/product/update")
	Product updateProduct(@RequestBody Product product);

	@PutMapping("api/product/updateAll")
	List<Product> updateProductLists(@RequestBody List<Product> prodLists);

	@GetMapping("api/product/{productId}")
	Optional<Product> findById(@PathVariable int productId);

	@GetMapping("api/product/find/{productName}")
	Optional<Product> findByProductName(@PathVariable String productName);

	@GetMapping("api/product/findAll")
	List<Product> fetchAll();

	@GetMapping("api/product/findAll/sorted")
	List<Product> fetchByAlphabeticalOrder();

	@DeleteMapping("api/product/{productId}")
	void deleteProduct(@PathVariable int productId);

	@GetMapping("api/product/minPrice/{minPrice}")
	List<Product> findByPriceLessThan(@PathVariable double minPrice);

	@GetMapping("api/product/find/price/{maxPrice}")
	List<Product> findByPriceGreaterThan(@PathVariable double maxPrice);

	@GetMapping("api/product/find/{minPrice}/{maxPrice}")
	List<Product> findByPriceIsBetween(@PathVariable double minPrice, @PathVariable double maxPrice);

}
