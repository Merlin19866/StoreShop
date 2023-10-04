package com.merlin.StoreShop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    
    public ProductTest() {
    }

    @Test
    public void testGettersDefault() 
    {
        
        Product instance = new Product("Asztal",500);
        
        assertEquals(instance.getName(), "Asztal");
        assertEquals(500, instance.getName());
        
       
    }

    @Test
    public void testWeight()
    {
        Product instance = new Product("Szék",15);
        
        assertEquals(15, instance.getWeight());
        
        
    }
    
}
