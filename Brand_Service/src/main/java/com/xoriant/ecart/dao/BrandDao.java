package com.xoriant.ecart.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.Brand;
@Repository
public interface BrandDao extends JpaRepository<Brand, Integer>{

	Optional<Brand> findByBrandName(String brandName);

}
