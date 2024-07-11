package com.sree.ecom_proj.service;

import com.sree.ecom_proj.model.Product;
import com.sree.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {

        return repo.findAll();

    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product){
        Product existingproduct=repo.findById(id).get();
        existingproduct.setName(product.getName());
        existingproduct.setDescription(product.getDescription());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setCategory(product.getCategory());
        existingproduct.setBrand(product.getBrand());
        existingproduct.setProductAvailable(product.isProductAvailable());
        existingproduct.setReleaseDate(product.getReleaseDate());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
