package com.greendookan.repository;

import com.greendookan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIsActiveTrue();

    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p WHERE p.stock < :threshold AND p.isActive = true")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);

    @Query("SELECT p FROM Product p WHERE p.stock = 0 AND p.isActive = true")
    List<Product> findOutOfStockProducts();

    @Query("SELECT DISTINCT p.category FROM Product p WHERE p.isActive = true")
    List<String> findAllCategories();

    Optional<Product> findByIdAndIsActiveTrue(Long id);
}
