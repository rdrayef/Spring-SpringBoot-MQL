package org.mql.stock.controllers;

import java.util.List;

import org.mql.stock.business.StockService;
import org.mql.stock.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private StockService service;

	public ProductController() {
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product p = service.product(id);
		if (p == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(p);
		}
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return service.products();
	}

	@GetMapping("/keyword/{keyword}")
	public List<Product> getProductsByKeyword(@PathVariable String keyword) {
		return service.getProductsByKeyword(keyword);
	}

	@GetMapping("/search")
	public List<Product> getProductsByName(@RequestParam String name) {
		return service.products(name);
	}

}
