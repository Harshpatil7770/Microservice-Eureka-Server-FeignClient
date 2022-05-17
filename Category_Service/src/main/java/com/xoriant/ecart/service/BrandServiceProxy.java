package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.ecart.dto.Brand;



@FeignClient(name="brand-service")
public interface BrandServiceProxy {

	@GetMapping("api/brand/find/{brandId}")
	Optional<Brand> findById(@PathVariable int brandId);

	@GetMapping("api/brand/fetchAll")
	List<Brand> fetchAll();

	@GetMapping("api/brand/fetchAll/alpha-order")
	List<Brand> fetchAllAlphabeticalOrder();
}
