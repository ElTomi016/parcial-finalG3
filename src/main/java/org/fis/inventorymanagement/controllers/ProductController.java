package org.fis.inventorymanagement.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.fis.inventorymanagement.models.Product;
import org.fis.inventorymanagement.models.Product;
import org.fis.inventorymanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Operations pertaining to products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("path")
    public Product postMethodName(@RequestBody Product entity) {
        //TODO: process POST request
        
        return productService.createProduct(entity);
    }

    @PostMapping
    public Product createSale(@RequestBody Product sale) {
        return productService.createSale(sale);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSaleById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateSale(@PathVariable int id, @RequestBody Product updatedSale) {
        return productService.updateproduct(id, updatedSale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable int id) {
        productService.deleteproduct(id);
    }
    
}
