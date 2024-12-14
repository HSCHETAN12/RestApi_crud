package org.Ey.RestCrudApi.repository;

import org.Ey.RestCrudApi.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
