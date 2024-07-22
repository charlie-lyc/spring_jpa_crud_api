package com.example.jpa_crud_api.service;

import com.example.jpa_crud_api.entity.Product;
import com.example.jpa_crud_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 3. Third
 */
@Service
public class ProductService {

    /**
     * NOT Recommended!
     */
    //@Autowired
    //private ProductRepository productRepository;
    //////////////////////////////////////////////////////////////
    private final ProductRepository productRepository;
    @Autowired
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "removed product id: " + id;
    }

    public Product updateProduct(Product product) {
        Product foundProduct = productRepository.findById(product.getId()).orElse(null);
        if (foundProduct != null) {
            foundProduct.setName(product.getName());
            foundProduct.setQuantity(product.getQuantity());
            foundProduct.setPrice(product.getPrice());
            return productRepository.save(foundProduct);
        }
        return null;
    }

}
