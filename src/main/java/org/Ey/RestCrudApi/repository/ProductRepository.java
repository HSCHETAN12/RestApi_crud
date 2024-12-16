package org.Ey.RestCrudApi.repository;

import java.util.List;
import java.util.Optional;

import org.Ey.RestCrudApi.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);

	List<Product> findByStackBetween(int min, int max);
	
}
