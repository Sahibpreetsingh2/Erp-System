package com.erp_ecom.Erp.service;

import com.erp_ecom.Erp.dto.ProductCategoryDto;
import com.erp_ecom.Erp.entity.ProductCategory;
import com.erp_ecom.Erp.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepo;

    public ProductCategory saveCategory(ProductCategoryDto dto) {

        ProductCategory category = new ProductCategory();

        category.setName(dto.getName());

        return categoryRepo.save(category);
    }

    public List<ProductCategory> getAll() {
        return categoryRepo.findAll();
    }

    public Optional<ProductCategory> getById(Long id) {
        return categoryRepo.findById(id);
    }

    public ProductCategory updateCategory(
            Long id,
            ProductCategoryDto dto) {

        Optional<ProductCategory> optionalCategory =
                categoryRepo.findById(id);

        if(optionalCategory.isPresent()) {

            ProductCategory category =
                    optionalCategory.get();

            category.setName(dto.getName());

            return categoryRepo.save(category);
        }

        return null;
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}