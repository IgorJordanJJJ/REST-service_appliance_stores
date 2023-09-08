package ru.jordan.appliancedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.appliancedata.models.Product;
import ru.jordan.appliancedata.models.Showcases;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByType(String type);
    List<Product> findByPriceBetween(BigDecimal onprice, BigDecimal  toprice);
    List<Product> findByShowcases(Showcases showcases);

}
