package org.Ey.RestCrudApi.controller;

import java.util.List;

import org.Ey.RestCrudApi.Service.ProductService;
import org.Ey.RestCrudApi.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	ProductService service;
	
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product)
	{
		return service.save(product);
	}
	
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> product)
	{
		return service.saveall(product);
	}
	
	@GetMapping("/products")
	public ResponseEntity<Object> fetch()
	{
		return service.fetch();
	}
	@GetMapping("/products/id")
	public ResponseEntity<Object> fetchId(int id)
	{
		return service.fetchId(id);
	}
	
}
