package com.xoriant.ecart.dao;

import com.xoriant.ecart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category,Integer>{
    Optional<Category> findByCategoryName(String categoryName);
}
