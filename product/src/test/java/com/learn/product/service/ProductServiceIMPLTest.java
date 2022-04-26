package com.learn.product.service;

import com.learn.product.dao.ProductDao;
import com.learn.product.exceptions.ProductAlreadyExistsException;
import com.learn.product.exceptions.ProductNotFoundException;
import com.learn.product.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceIMPLTest {


        @Mock
        ProductDao dao;

        @InjectMocks
        ProductServiceIMPL productServiceIMPL;


        @Test
        public void givennullProductNameThenReturnNull() throws ProductNotFoundException, ProductAlreadyExistsException {
            Product product = new Product("1","null","Blue","Hugo","Clothes");
            assertEquals(product.getName(),null);
        }

        @Test
        public void givenRedundantCallThenDontSave() throws ProductNotFoundException, ProductAlreadyExistsException {
            Product product = new Product("1","Blue Shirt","Blue","Hugo","Clothes");
            Product optionalProduct = new Product();
            Mockito.verify(dao,times(0)).save(optionalProduct);
        }

        @Test
        public void givenDuplicatesThenDoesNotCallSaveMethod() throws ProductAlreadyExistsException {
            Product product = new Product("1","Blue Shirt","Blue","Hugo","Clothes");
            Optional<Product> optionalProduct = Optional.of(product);
            verify(dao,times(0)).findById("1");
            verify(dao,times(0)).save(product);
        }
    }
