package com.example.jpa_crud_api.repository;

import com.example.jpa_crud_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2. Second
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
