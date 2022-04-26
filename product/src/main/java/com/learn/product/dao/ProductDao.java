package com.learn.product.dao;

import com.learn.product.exceptions.ProductNotFoundException;
import com.learn.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductDao extends MongoRepository<Product,String> {

List<Product> findByCategory(String category) throws ProductNotFoundException;

}

