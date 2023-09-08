package ru.jordan.appliancedata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jordan.appliancedata.models.Product;
import ru.jordan.appliancedata.models.Showcases;
import ru.jordan.appliancedata.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/type/{productType}")
    public List<Product> getProductsByType(@PathVariable String productType){
        return productService.findByType(productType);
    }

    @GetMapping("/priceRange")
    public List<Product> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice
    ) {
        return productService.findByBetweenPrice(minPrice, maxPrice);
    }

    @GetMapping("/showcases/{storeId}")
    public List<Product> getProductsByStore(@PathVariable int storeId) {
        Showcases showcases = new Showcases();
        showcases.setId(storeId);
        return productService.getProductsByShowcases(showcases);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        productService.update(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.delete(id);
    }

}
