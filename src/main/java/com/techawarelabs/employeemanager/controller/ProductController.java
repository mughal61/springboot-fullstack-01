package com.techawarelabs.employeemanager.controller;

import com.techawarelabs.employeemanager.exception.ProductNotFoundException;
import com.techawarelabs.employeemanager.model.Product;
import com.techawarelabs.employeemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProductList();
    }

    @GetMapping("/products/{pid}")
    public Product getProduct(@PathVariable(value = "pid") Long id) {
        return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/products/{pid}")
    public void updateProduct(@RequestBody Product product, @PathVariable Long pid) {
        productService.updateProduct(pid, product);
    }

    @DeleteMapping("/products/{pid}")
    public void deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
    }
}
