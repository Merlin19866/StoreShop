package com.merlin.StoreShop.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>

{
    Product save(Product product);
    List<Product>findAllByOrderByName();
    List<Product>findAllByOrderById();
    List<Product>findAll();
    void delete(Product product);
   
    
    
}
