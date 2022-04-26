package com.learn.product.service;

import com.learn.product.dao.ProductDao;
import com.learn.product.exceptions.ProductAlreadyExistsException;
import com.learn.product.exceptions.ProductNotFoundException;
import com.learn.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceIMPL implements ProductService {
    private ProductDao dao;

    @Autowired
    public ProductServiceIMPL(ProductDao dao) {
        this.dao = dao;
    }


    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistsException {
        if (dao.existsById(product.getId())) {
            throw new ProductAlreadyExistsException("Product Already exists");
        } else {
        product.setId(UUID.randomUUID().toString());
            return dao.save(product);
        }}



    @Override
    public Product getProduct(String id) throws ProductNotFoundException {
        final Optional<Product> productOptional = dao.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product for this ID not Found");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getProductByCategory(String category) throws ProductNotFoundException {
        List<Product> products =  dao.findByCategory(category);
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allMates = new ArrayList<>();
        dao.findAll().forEach(product -> allMates.add(product));
        return allMates;
    }

    @Override
    public void getById(int i) {
    }

}
