package com.learn.product.controller;

import com.learn.product.exceptions.ProductAlreadyExistsException;
import com.learn.product.exceptions.ProductNotFoundException;
import com.learn.product.model.Product;
import com.learn.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProdcutController {

        private static Logger logger = LoggerFactory.getLogger(ProdcutController.class);

        private ProductService service;

        @Autowired
        public ProdcutController(ProductService service) {
            this.service = service;
        }

        @GetMapping("/info")
//	@RequestMapping(path = "/info", method = RequestMethod.GET)
        public String apiInfo() {
            return "Product API is UP and Running : Query parameters : ";
        }

        @GetMapping("/view")
        public List<Product> getProduct() {
            return service.getAllProducts();

        }

        @GetMapping("/{category}")
        public List<Product> getProductsByCategory(@PathVariable String category) throws ProductNotFoundException {
            logger.info("product ID received : {}", category);
            return (List<Product>) service.getProductByCategory(category);
        }


        @PostMapping("/add")
        public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
            Product addProduct = service.addProduct(product);
            return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
        }

    }


