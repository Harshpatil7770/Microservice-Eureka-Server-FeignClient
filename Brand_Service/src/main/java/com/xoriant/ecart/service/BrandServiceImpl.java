package com.xoriant.ecart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.BrandDao;
import com.xoriant.ecart.exception.ElementNotFoundException;
import com.xoriant.ecart.exception.UserInputException;
import com.xoriant.ecart.model.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public Brand addNewBrand(Brand brand) {
		if (brand.getBrandName().isBlank() || brand.getBrandName().isEmpty() || brand.getBrandName().length() == 0) {
			throw new UserInputException();
		}
		return brandDao.save(brand);
	}

	@Override
	public List<Brand> addNewListOfBrands(List<Brand> brandLists) {
		for (Brand newBrand : brandLists) {
			if (newBrand.getBrandName().isBlank() || newBrand.getBrandName().isEmpty()
					|| newBrand.getBrandName().length() == 0) {
				throw new UserInputException();
			}
		}
		return brandDao.saveAll(brandLists);
	}

	@Override
	public Brand updateBrand(Brand brand) {
		Optional<Brand> isExistBrand = brandDao.findById(brand.getBrandId());
		if (!isExistBrand.isPresent()) {
			throw new ElementNotFoundException();
		}

		Brand updateBrand = brandDao.findById(brand.getBrandId()).orElse(null);

		updateBrand.setBrandId(brand.getBrandId());
		if (brand.getBrandName().isBlank() || brand.getBrandName().isEmpty()
				|| brand.getBrandName().length() == 0) {
			throw new UserInputException();
		}
		updateBrand.setBrandName(brand.getBrandName());
		return brandDao.save(brand);

	}

	@Override
	public Optional<Brand> findByBrandName(String brandName) {

		Optional<Brand> isExistBrand = brandDao.findByBrandName(brandName);
		if (!isExistBrand.isPresent()) {
			throw new ElementNotFoundException();
		}

		return isExistBrand;
	}

	@Override
	public Optional<Brand> findById(int brandId) {
		Optional<Brand> isExistBrand = brandDao.findById(brandId);
		if (!isExistBrand.isPresent()) {
			throw new ElementNotFoundException();
		}
		return isExistBrand;
	}

	@Override
	public List<Brand> fetchAll() {
		List<Brand> existingBrandLists = brandDao.findAll();
		if (existingBrandLists == null) {
			throw new ElementNotFoundException();
		}
		return existingBrandLists;
	}

	@Override
	public List<Brand> fetchAllAlphabeticalOrder() {
		List<Brand> existingBrandLists = brandDao.findAll();
		if (existingBrandLists == null) {
			throw new ElementNotFoundException();
		}
		List<Brand> alphabeticalOrderBrandLists = existingBrandLists.stream()
				.sorted((o1, o2) -> o1.getBrandName().compareTo(o2.getBrandName())).collect(Collectors.toList());
		return alphabeticalOrderBrandLists;
	}

	@Override
	public List<Brand> updateListsOfBrand(List<Brand> brandLists) {
		List<Brand> updatedBrandList = new ArrayList<>();
		for (Brand isExistBrand : brandLists) {
			Optional<Brand> eachBrand = brandDao.findById(isExistBrand.getBrandId());
			if (!eachBrand.isPresent()) {
				throw new ElementNotFoundException();
			}
		}

		for (Brand newBrand : brandLists) {
			if (newBrand.getBrandName().isBlank() || newBrand.getBrandName().isEmpty()
					|| newBrand.getBrandName().length() == 0) {
				throw new UserInputException();
			}
		}

		for (Brand updateBrand : brandLists) {
			Brand eachBrand = brandDao.findById(updateBrand.getBrandId()).orElse(null);
			eachBrand.setBrandId(updateBrand.getBrandId());
			eachBrand.setBrandName(updateBrand.getBrandName());
			brandDao.save(updateBrand);
			updatedBrandList.add(eachBrand);
		}

		return updatedBrandList;
	}

	@Override
	public void deleteBrand(int brandId) {
		Optional<Brand> isExistBrand = brandDao.findById(brandId);
		if (!isExistBrand.isPresent()) {
			throw new ElementNotFoundException();
		}
		brandDao.deleteById(brandId);

	}

}
