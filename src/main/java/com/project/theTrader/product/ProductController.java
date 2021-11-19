package com.project.theTrader.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PostMapping(value="/product", consumes={"application/json"}) // C
    private Long createProduct(@RequestBody Product product) {
        productService.create(product);
        return product.getId();
    }
   
    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/products") // R -> All
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/product/{productid}") // R -> ById
    private Product getProduct(@PathVariable("productid") Long productid) {
        return productService.getProductById(productid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/product") // U
    private Product updateProduct(@RequestBody Product product, Long productid) {
        productService.update(product, productid);
        return product;
    }
    
    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @DeleteMapping("/product/{productid}") // D
    private void deleteProduct(@PathVariable("productid") Long productid) {
        productService.delete(productid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("creditsProduct/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private double getCreditsProduct(@PathVariable("productid") Long productid){
        return productService.getCreditsProduct(productid);
    }
}
