package com.loqoai.ProductFinder.service;

import com.loqoai.ProductFinder.entity.Product;

import java.util.List;

/**
 * The ProductService interface defines the contract for the service layer
 * related to {@link Product} entities. It provides methods for retrieving
 * filtered and sorted product data based on various criteria.
 */
public interface ProductService {

    /**
     * Retrieves a list of products based on the specified filter and sort criteria.
     *
     * @param category   The category to filter products by (optional).
     * @param minPrice   The minimum price to filter products by (optional).
     * @param maxPrice   The maximum price to filter products by (optional).
     * @param inStock    The stock availability to filter products by (optional).
     * @param sortField  The field by which to sort the products (optional). Valid values are "price", "rating", and "createdAt".
     * @param sortOrder  The order of sorting (optional). Valid values are "asc" for ascending and "desc" for descending. Default is "asc".
     * @return A list of {@link Product} objects that match the specified criteria.
     */
    List<Product> getFilteredProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder);
}
