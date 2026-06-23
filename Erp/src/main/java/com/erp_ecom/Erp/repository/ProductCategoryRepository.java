package com.erp_ecom.Erp.repository;

import com.erp_ecom.Erp.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository
        extends JpaRepository<ProductCategory, Long> {
}