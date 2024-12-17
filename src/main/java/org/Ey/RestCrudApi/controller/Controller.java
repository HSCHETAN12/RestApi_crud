package org.Ey.RestCrudApi.controller;

import java.util.List;

import org.Ey.RestCrudApi.Service.ProductService;
import org.Ey.RestCrudApi.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchID(@PathVariable int id)
	{
		return service.fetchId(id);
	}
	
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> fetchByname(@PathVariable String name)
	{
		return service.fetchByName(name);
	}
	
	@GetMapping("/products/name/{min}/{max}")
	public ResponseEntity<Object> fetchByname(@PathVariable int min,@PathVariable int max)
	{
		return service.fetchByPriceBetween(min,max);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> fetchByname(@PathVariable int id)
	{
		return service.DeleteById(id);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Object> UpdateProduct(@RequestBody Product product)
	{
		return service.UpdateById(product);
	}
	
	@PatchMapping("/products/{id}")
	public ResponseEntity<Object> UpdateProductId(@PathVariable int id, @RequestBody Product product)
	{
		return service.UpdateByValue(id,product);
	}
	
}
