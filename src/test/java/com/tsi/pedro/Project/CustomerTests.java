package com.tsi.pedro.Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTests {

    @Test
    public void testGetCustomer_id(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.setCustomer_id(1);
        Assertions.assertEquals(1, testCustomer.getCustomer_id(), "id not found.");
    }
    @Test
    public void testSetCustomer_id(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.setCustomer_id(1);
        Assertions.assertEquals(1, testCustomer.getCustomer_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        Assertions.assertEquals("testFName", testCustomer.getFirst_name(), "first name not found.");
    }
    @Test
    public void testSetFirst_name(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testCustomer.getFirst_name(), "first name not set.");
    }
    @Test
    public void testGetLast_name(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.getLast_name();
        Assertions.assertEquals("testLName", testCustomer.getLast_name(), "last name not found.");
    }
    @Test
    public void testSetLast_name(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testCustomer.getLast_name(), "last name not set.");
    }
    @Test
    public void testGetEmail(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.getEmail();
        Assertions.assertEquals("example@email.com", testCustomer.getEmail(), "email not found.");
    }
    @Test
    public void testSetEmail(){
        Customer testCustomer = new Customer("testFName", "testLName", "example@email.com");
        testCustomer.setEmail("replacedemail@example.com");
        Assertions.assertEquals("replacedemail@example.com", testCustomer.getEmail(), "email not set.");
    }
}
