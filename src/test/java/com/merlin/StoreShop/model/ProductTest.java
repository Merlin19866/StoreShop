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
    
    @Test
    public void testToString() {
    // csak 'public' methódusokat
    // constructor, getter, setter nem teszteljük
    // given - when - then
    
    //Given - Kiindulás
     Product instance = new Product("Szék",15);
     String expectation = "Product{id=0, name=Szék, unittype=null, weight=15}";
     
     //Then - Csinál (methódus hívás)
     String result = instance.toString();
     
     //Then - Végeredmény
     assertEquals(expectation, result);
    }
    
    // TDD: 'test driven development'
    // Unit test - integrációs teszt - end-to-end
    
}
