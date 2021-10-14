package com.techawarelabs.employeemanager.controller;

import com.techawarelabs.employeemanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductWebController {
    @Autowired
    public ProductController productController;

    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> productList = productController.getAllProducts();
        model.addAttribute("products", productList);
        return "listProduct";
    }

    @GetMapping("/new_product")
    public String addNewProducts(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/save_new")
    public String saveNewProducts(@ModelAttribute("product") Product product) {
        productController.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/update_product/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productController.getProduct(id));
        return "updateProduct";
    }

    @PostMapping("/save_update")
    public String saveUpdateProduct(@ModelAttribute("product") Product product) {
        productController.updateProduct(product, product.getId());
        return "redirect:/";
    }


    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productController.getProduct(id));
        return "deleteProduct";
    }

    @PostMapping("/save_delete")
    public String saveDeleteProduct(@ModelAttribute("product") Product product) {
        productController.deleteProduct(product.getId());
        return "redirect:/";
    }
}
