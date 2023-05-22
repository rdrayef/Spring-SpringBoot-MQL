package org.mql.stock.business;

import java.util.List;
import java.util.Optional;

import org.mql.stock.models.Product;
import org.mql.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceDefault implements StockService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product product(int id) {
		// Optional pour regler les problemes de null
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent())return p.get();
		return null;
	}

	@Override
	public List<Product> products() {

		return productRepository.findAll();
	}

	@Override
	public List<Product> products(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> getProductsByKeyword(String keyword) {
		return productRepository.findByKeyword(keyword);
	}
}
