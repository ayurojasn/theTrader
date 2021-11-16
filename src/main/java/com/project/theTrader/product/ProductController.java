package com.project.theTrader.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;


    @PostMapping(value="/product", consumes={"application/json"}) // C
    private Long createProduct(@RequestBody Product product) {
        productService.create(product);
        return product.getId();
    }
    
    @GetMapping("/products") // R -> All
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productid}") // R -> ById
    private Product getProduct(@PathVariable("productid") Long productid) {
        return productService.getProductById(productid);
    }

    @PutMapping("/product") // U
    private Product updateProduct(@RequestBody Product product, Long productid) {
        productService.update(product, productid);
        return product;
    }
    
    @DeleteMapping("/product/{productid}") // D
    private void deleteProduct(@PathVariable("productid") Long productid) {
        productService.delete(productid);
    }

    
    @GetMapping("creditsProduct/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private double getCreditsProduct(@PathVariable("productid") Long productid){
        return productService.getCreditsProduct(productid);
    }
}
