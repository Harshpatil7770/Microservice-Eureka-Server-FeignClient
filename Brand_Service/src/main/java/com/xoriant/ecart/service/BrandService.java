package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.ecart.model.Brand;

public interface BrandService {

	Brand addNewBrand(Brand brand);

	List<Brand> addNewListOfBrands(List<Brand> brandLists);

	Brand updateBrand(Brand brand);

	Optional<Brand> findByBrandName(String brandName);

	Optional<Brand> findById(int brandId);

	List<Brand> fetchAll();

	List<Brand> fetchAllAlphabeticalOrder();

	List<Brand> updateListsOfBrand(List<Brand> brandLists);

	void deleteBrand(int brandId);
}
