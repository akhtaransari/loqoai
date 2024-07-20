package com.loqoai.ProductFinder;

import com.loqoai.ProductFinder.entity.Product;
import com.loqoai.ProductFinder.repository.ProductRepository;
import com.loqoai.ProductFinder.service.ProductServiceIMPL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

/**
 * Tests for the ProductFinder application.
 * This class verifies the functionality of the ProductServiceIMPL service.
 */
@SpringBootTest
class ProductFinderApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductServiceIMPL productService;

	/**
	 * Clear the repository before each test to ensure a clean slate.
	 */
	@BeforeEach
	void setUp() {
		productRepository.deleteAll();
	}

	/**
	 * Test case for the getFilteredProducts method in ProductServiceIMPL.
	 * Verifies that products are correctly filtered and sorted.
	 */
	@Test
	void testGetFilteredProducts() {
		// Create and save test products
		Product product1 = new Product("Smartphone", "electronics", 299.99, true, 4.5, new Date());
		Product product2 = new Product("Laptop", "electronics", 899.99, true, 4.7, new Date());

		productRepository.save(product1);
		productRepository.save(product2);

		// Fetch filtered and sorted products
		List<Product> products = productService.getFilteredProducts("electronics", 100.0, 1000.0, true, "price", "asc");

		// Assertions to validate the result
		assertThat(products).hasSize(2);
		assertThat(products)
				.extracting(Product::getName)
				.containsExactly("Smartphone", "Laptop");
	}
}
