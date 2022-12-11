package com.example.springAttest.services;

import com.example.springAttest.models.Product;
import com.example.springAttest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public Product getProductId(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    @Transactional
    public void updateProduct(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
