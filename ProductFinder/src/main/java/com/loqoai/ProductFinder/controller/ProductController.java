package com.loqoai.ProductFinder.controller;

import com.loqoai.ProductFinder.entity.Product;
import com.loqoai.ProductFinder.service.ProductService;
import com.loqoai.ProductFinder.service.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// The ProductController class handles HTTP requests for product operations.
@RestController
public class ProductController {

    // Service layer dependency interface for handling business logic related to products.
    private final ProductService productService;

    // Constructor injection for the ProductService implementation.
    @Autowired
    public ProductController(ProductServiceIMPL productService) {
        this.productService = productService;
    }

    /**
     * Endpoint to get filtered and sorted products based on query parameters.
     *
     * @param category  Optional query parameter to filter products by category.
     * @param minPrice  Optional query parameter to filter products by minimum price.
     * @param maxPrice  Optional query parameter to filter products by maximum price.
     * @param inStock   Optional query parameter to filter products by stock availability.
     * @param sortField Optional query parameter to specify the field to sort by (e.g., price, rating, createdAt).
     * @param sortOrder Optional query parameter to specify the sort order (asc or desc). Default is asc.
     * @return          A ResponseEntity containing a list of products that match the filtering and sorting criteria and an HTTP status code.
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) String sortOrder) {
        List<Product> products = productService.getFilteredProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);

        // Return a ResponseEntity with the products list and an OK status.
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
