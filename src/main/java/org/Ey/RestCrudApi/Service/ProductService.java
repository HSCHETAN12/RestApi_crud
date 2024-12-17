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
		if(list.isEmpty())
		{
			map.put("message","Products Not found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			map.put("message","Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		
	}

	public ResponseEntity<Object> fetchId(int id) {
		Optional<Product> product=repository.findById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		if(product.isEmpty())
		{
			map.put("message","Products Not found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			map.put("message","Products Found with id:"+id);
			map.put("data", product);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		
	}

	public ResponseEntity<Object> fetchByName(String name) {
		List<Product> product=repository.findByName(name);
		Map<String, Object> map=new HashMap<String, Object>();
		if(product.isEmpty())
		{
			map.put("message","Products Not found with name:"+name);
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			map.put("message","Products Found with name:"+name);
			map.put("data", product);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByPriceBetween(int min, int max) {
		List<Product> product=repository.findByStackBetween(min,max);
		Map<String, Object> map=new HashMap<String, Object>();
		if(product.isEmpty())
		{
			map.put("message","Products Not found Between:"+min+"and"+max);
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			map.put("message","Products Found :");
			map.put("data", product);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> DeleteById(int id) {
		Optional<Product> product=repository.findById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		if(product.isEmpty())
		{
			map.put("message","Products Not found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			repository.deleteById(id);
			map.put("message","Product Deleted");
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> UpdateById(Product product) {
		repository.save(product);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "product Updated Sucess");
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> UpdateByValue(int id, Product product) {
		Optional<Product> optional =repository.findById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		if(optional.isEmpty())
		{
			map.put("message","Products Not found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
		else {
			Product existingProduct=optional.get();
			if(product.getName()!=null)
				existingProduct.setName(product.getName());
			if(product.getDescription()!=null)
				existingProduct.setDescription(product.getDescription());
			if(product.getPrice()!=0)
				existingProduct.setPrice(product.getPrice());
			if(product.getStack()!=0)
				existingProduct.setStack(product.getStack());
			repository.save(existingProduct);
			
			map.put("message","Product get updated");
			
			return new ResponseEntity<Object>(map,HttpStatus.OK);
			
		}
		
		
	}

}
