package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StaffTest {

    @Test
    public void testGetStaff_id(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setStaff_id(1);
        Assertions.assertEquals(1, testStaff.getStaff_id(), "id not found.");
    }
    @Test
    public void testSetStaff_id(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setStaff_id(1);
        Assertions.assertEquals(1, testStaff.getStaff_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals("test", testStaff.getFirst_name(), "first name not found.");
    }
    @Test
    public void testSetFirst_name(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testStaff.getFirst_name(), "first name not set.");
    }
    @Test
    public void testGetLast_name(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals("testl", testStaff.getLast_name(), "Last name not found.");
    }
    @Test
    public void testSetLast_name(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testStaff.getLast_name(), "Last name not set.");
    }
    @Test
    public void testGetAddressId(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals(1, testStaff.getAddress_id(), "Address not found.");
    }
    @Test
    public void testSetAddressId(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setAddress_id(2);
        Assertions.assertEquals(2, testStaff.getAddress_id(), "Address not set.");
    }
    @Test
    public void testGetEmail(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals("fake@email.com", testStaff.getEmail(), "Email not found.");
    }
    @Test
    public void testSetEmail(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setEmail("fakest@email.com");
        Assertions.assertEquals("fakest@email.com", testStaff.getEmail(), "Email not set.");
    }
    @Test
    public void testGetUser(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals("mike", testStaff.getUsername(), "User not found.");
    }
    @Test
    public void testSetUser(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setUsername("tim");
        Assertions.assertEquals("tim", testStaff.getUsername(), "username not set.");
    }
    @Test
    public void testGetPass(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        Assertions.assertEquals("johnson", testStaff.getPassword(), "password not found.");
    }
    @Test
    public void testSetPass(){
        Staff testStaff = new Staff("test", "testl", 1, "fake@email.com", "mike", "johnson");
        testStaff.setPassword("spaghetto");
        Assertions.assertEquals("spaghetto", testStaff.getPassword(), "password not set.");
    }












}
