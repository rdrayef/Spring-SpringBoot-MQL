package org.mql.stock.business;

import java.util.List;

import org.mql.stock.models.Product;
import org.springframework.stereotype.Service;


public interface StockService {

	public Product product(int id);

	public List<Product> products();

	public List<Product> products(String name);

	public List<Product> getProductsByKeyword(String keyword);

}
