package com.loqoai.ProductFinder.repository;

import com.loqoai.ProductFinder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing {@link Product} entities from the database.
 * This interface extends {@link JpaRepository}, which provides basic CRUD operations and custom query methods for the {@link Product} entity.

 * The {@link JpaRepository} interface includes methods such as:
 * - save(): to save an entity
 * - findById(): to find an entity by its ID
 * - findAll(): to retrieve all entities
 * - deleteById(): to delete an entity by its ID

 * The ProductRepository interface does not need to define any additional methods
 * for basic CRUD operations, but custom methods can be added if needed.
 *
 * @see Product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional custom query methods can be defined here if required.
}
