package com.xoriant.ecart.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.service.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/save")
	Brand addNewBrand(@RequestBody Brand brand) {
		return brandService.addNewBrand(brand);
	}

	@PostMapping("/saveAll")
	List<Brand> addNewListOfBrands(@RequestBody List<Brand> brandLists) {
		return brandService.addNewListOfBrands(brandLists);
	}

	@PutMapping("/update")
	Brand updateBrand(@RequestBody Brand brand) {
		return brandService.updateBrand(brand);
	}

	@GetMapping("/{brandName}")
	Optional<Brand> findByBrandName(@PathVariable String brandName) {
		return brandService.findByBrandName(brandName);
	}

	@GetMapping("/find/{brandId}")
	Optional<Brand> findById(@PathVariable int brandId) {
		return brandService.findById(brandId);

	}

	@GetMapping("/fetchAll")
	List<Brand> fetchAll() {
		return brandService.fetchAll();

	}

	@GetMapping("/fetchAll/alpha-order")
	List<Brand> fetchAllAlphabeticalOrder() {
		return brandService.fetchAllAlphabeticalOrder();

	}

	@PutMapping("/updateAll")
	List<Brand> updateListsOfBrand(@RequestBody List<Brand> brandLists) {
		return brandService.updateListsOfBrand(brandLists);
	}

	@DeleteMapping("/delete/{brandId}")
	String deleteBrand(@PathVariable int brandId) {
		brandService.deleteBrand(brandId);
		String response = "Delete Brand Succesfully !";
		return response;
	}
}
