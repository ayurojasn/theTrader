package com.project.theTrader.product;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class ProductService{
    
    @Autowired
    ProductRepository productRepository;

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){  
        List<Product> products = new ArrayList<Product>();  
        productRepository.findAll().forEach(product1 -> products.add(product1));  
        return products;  
    }

    public Product getProductById(Long productid) {
        return productRepository.findById(productid).get();
    }

    public void update(Product product, Long productid) {
        productRepository.save(product);
    }  

    public void delete(Long productid) { //Arreglar
        productRepository.deleteById(productid);
    }

    public double getCreditsProduct(Long productid){
        double credits;
        Product product = new Product();
        product = getProductById(productid);
        credits = product.getPc();

        return credits;
    }
}
