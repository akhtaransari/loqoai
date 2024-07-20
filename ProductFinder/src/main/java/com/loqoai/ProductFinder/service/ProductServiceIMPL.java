package com.loqoai.ProductFinder.service;

import com.loqoai.ProductFinder.repository.ProductRepository;
import com.loqoai.ProductFinder.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The ProductServiceIMPL class implements the business logic for filtering and sorting {@link Product} entities.
 * It interacts with the {@link ProductRepository} to retrieve products and applies filtering and sorting based on
 * the provided criteria.
 */
@Service
public class ProductServiceIMPL implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor to initialize ProductServiceIMPL with the ProductRepository.
     *
     * @param productRepository The repository used for interacting with the product data store.
     */
    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves a list of products filtered and sorted based on the specified criteria.
     *
     * @param category   The category to filter products by (optional).
     * @param minPrice   The minimum price to filter products by (optional).
     * @param maxPrice   The maximum price to filter products by (optional).
     * @param inStock    The stock availability to filter products by (optional).
     * @param sortField  The field by which to sort the products (optional). Valid values are "price", "rating", and "createdAt".
     * @param sortOrder  The order of sorting (optional). Valid values are "asc" for ascending and "desc" for descending. Default is "asc".
     * @return A list of {@link Product} objects that match the specified criteria, filtered and sorted accordingly.
     */
    @Override
    public List<Product> getFilteredProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
        // Retrieve all products from the repository
        List<Product> products = productRepository.findAll();

        // Apply filtering based on the provided criteria
        products = products.stream()
                .filter(product -> category == null || product.getCategory().equals(category))
                .filter(product -> minPrice == null || product.getPrice() >= minPrice)
                .filter(product -> maxPrice == null || product.getPrice() <= maxPrice)
                .filter(product -> inStock == null || product.isInStock() == inStock)
                .collect(Collectors.toList());

        // Apply sorting based on the provided sortField and sortOrder
        if (sortField != null && sortOrder != null) {
            Sort.Direction direction = Sort.Direction.fromString(sortOrder);
            switch (sortField) {
                case "price":
                    products.sort((p1, p2) -> direction.isAscending() ? Double.compare(p1.getPrice(), p2.getPrice()) : Double.compare(p2.getPrice(), p1.getPrice()));
                    break;
                case "rating":
                    products.sort((p1, p2) -> direction.isAscending() ? Double.compare(p1.getRating(), p2.getRating()) : Double.compare(p2.getRating(), p1.getRating()));
                    break;
                case "createdAt":
                    products.sort((p1, p2) -> direction.isAscending() ? p1.getCreatedAt().compareTo(p2.getCreatedAt()) : p2.getCreatedAt().compareTo(p1.getCreatedAt()));
                    break;
                default:
                    break;
            }
        }

        return products;
    }
}
