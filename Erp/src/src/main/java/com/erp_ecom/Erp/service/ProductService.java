package com.erp_ecom.Erp.service;

import com.erp_ecom.Erp.dto.ProductDto;
import com.erp_ecom.Erp.entity.Product;
import com.erp_ecom.Erp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product saveProduct(ProductDto dto){

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
//        product.setStock(dto.getStock());

        return productRepo.save(product);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public Optional<Product> getById(Long id){
        return productRepo.findById(id);
    }

    public Product updateProduct(Long id, ProductDto dto) {

        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isPresent()) {

            Product product = optionalProduct.get();

            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
//            product.setStock(dto.getStock());

            return productRepo.save(product);
        }

        return null;
    }

    public void delete(Long id){
        productRepo.deleteById(id);
    }
}
