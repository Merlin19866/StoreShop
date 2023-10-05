
package com.merlin.StoreShop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gazda
 */
public class CustomerTest {

    public CustomerTest() {
    }

    @Test
    public void testGetName() {
        Customer testCustomer = new Customer("test name", "test type", "test payment");

        String result = testCustomer.getName();
        
        assertEquals(result, "test name");
    }

    @Test
    public void testGetType() {
    }

    @Test
    public void testGetPayment() {
    }

    @Test
    public void testSetName() {
    }

    @Test
    public void testSetType() {
    }

    @Test
    public void testSetPayment() {
    }

    @Test
    public void testToString() {
    }

}
