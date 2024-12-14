package org.Ey.RestCrudApi.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.Ey.RestCrudApi.dto.Product;
import org.Ey.RestCrudApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;

	public ResponseEntity<Object> save(Product product) {
		repository.save(product);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "product added Sucess");
		map.put("data", product);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> saveall(List<Product> product) {
		repository.saveAll(product);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "product added Sucess");
		map.put("data", product);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> fetch() {
		List<Product> list=repository.findAll();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("data", list);
		return new ResponseEntity<Object>(map,HttpStatus.FOUND);
	}

	public ResponseEntity<Object> fetchId(int id) {
		Optional<Product> product=repository.findById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("data", product);
		return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
		
	}

}
