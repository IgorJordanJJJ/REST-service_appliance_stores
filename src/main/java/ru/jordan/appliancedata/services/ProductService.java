package ru.jordan.appliancedata.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.appliancedata.models.Product;
import ru.jordan.appliancedata.models.Showcases;
import ru.jordan.appliancedata.repositories.ProductRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(int uuid) {
        Optional<Product> foundProduct = productRepository.findById(uuid);
        return foundProduct.orElse(null);
    }

    @Transactional
    public void save(Product product) {
        product.setDatecreate(new Date());
        product.setDatechange(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
    }

    @Transactional
    public void update(int uuid, Product product) {
        product.setId(uuid);
        product.setDatechange(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
    }


    @Transactional
    public void delete(int uuid) {
        productRepository.deleteById(uuid);
    }

    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }
    public List<Product> findByBetweenPrice(BigDecimal onprice, BigDecimal  toprice){
        return productRepository.findByPriceBetween(onprice, toprice);
    }

    public List<Product> getProductsByShowcases(Showcases showcases) {
        return productRepository.findByShowcases(showcases);
    }

}

