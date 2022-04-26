package com.learn.product.dao;

import com.learn.product.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest

class ProductDaoTest {
    @Autowired
    ProductDao dao;


    @Test
    public void givenNewProductWhenSavedThenReturnProduct(){
        Product product = new Product("1","Blue Shirt","Blue","Hugo","Clothes");
        Product product1 = dao.save(product);
        assertEquals(product.getId(),product1.getId(), "New Employee should be saved and the same should be returned");
    }

    @Test
    public void givenInValidProductIdThenReturnEmptyOptional(){
        assertTrue(dao.findById("1").isEmpty());
    }

    @Test
    public void givenValidProductIdThenReturnProductOptional(){
        Product product = new Product("1","Blue Shirt","Blue","Hugo","Clothes");
        dao.save(product);
        assertTrue(dao.findById("1").isPresent());

    }

}