package com.merlin.StoreShop.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//ezzel mondom meg,hogy ez a model osztály spring komponens
public class Model 
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository  productRepository;
    @Autowired
    private ProcurementRepository procurementRepository;
    
    public void save(Customer customer)
    {
        customerRepository.save(customer);
    }
    public List<Customer>getCustomers()
    {
        return customerRepository.findAllByOrderById();
    }
    public void delete(Customer cusomer)
    {
        customerRepository.delete(cusomer);
    }
    public void delete(Product product)
    {
        productRepository.delete(product);
    }
   
    public void save(Product product)
{
    productRepository.save(product);
}
    public List<Product>getProducts()
    {
        return productRepository.findAllByOrderById();
    }
    public void save(Procurement procurement)
    {
        procurementRepository.save(procurement);
    }
    
}