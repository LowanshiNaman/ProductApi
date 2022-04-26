package com.learn.product.service;

import com.learn.product.exceptions.ProductAlreadyExistsException;
import com.learn.product.exceptions.ProductNotFoundException;
import com.learn.product.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product) throws ProductAlreadyExistsException;
    Product getProduct(String id) throws ProductNotFoundException;
    List<Product> getProductByCategory(String category) throws ProductNotFoundException;
    List<Product> getAllProducts();

    void getById(int i);
}
