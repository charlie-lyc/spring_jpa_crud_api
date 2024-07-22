package com.example.jpa_crud_api.controller;

import com.example.jpa_crud_api.entity.Product;
import com.example.jpa_crud_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 4. Fourth
 */
@RestController
public class ProductController {

    /**
     * NOT Recommended!
     */
    //@Autowired
    //private ProductService productService;
    //////////////////////////////////////////////////////////////
    private final ProductService productService;
    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }
    //////////////////////////////////////////////////////////////
    /**
     * Health Check!
     */
    @GetMapping("/")
    public String hello() {
        return "This is Seawater-EMS";
    }
    //////////////////////////////////////////////////////////////

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    /**
     * Ambiguous handler method, comparing above method!
     */
    //@GetMapping("/product/{name}")
    //public Product getProductByName(@PathVariable String name) {
    //    return productService.getProductByName(name);
    //}

    @GetMapping("/product")
    public Product getProductByName(@RequestParam(required = false) String name) {
        return productService.getProductByName(name);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}