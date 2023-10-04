package com.merlin.StoreShop.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
    Customer save(Customer customer);
    List<Customer>findAllByOrderById();
    List<Customer>findAllByOrderByName();
    
   

    
}
