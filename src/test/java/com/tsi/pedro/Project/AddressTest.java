package com.tsi.pedro.Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    public void testGetAddress_id(){
        Address testAddress = new Address("testAddress", "testDistrict");
        testAddress.setAddress_id(1);
        Assertions.assertEquals(1, testAddress.getAddress_id(), "id not found.");
    }
    @Test
    public void testSetAddress_id(){
        Address testAddress = new Address("testAddress", "testDistrict");
        testAddress.setAddress_id(1);
        Assertions.assertEquals(1, testAddress.getAddress_id(), "id not set.");
    }
    @Test
    public void testGetAddress(){
        Address testAddress = new Address("testAddress", "testDistrict");
        Assertions.assertEquals("testAddress", testAddress.getAddress(), "address not found.");
    }
    @Test
    public void testSetAddress(){
        Address testAddress = new Address("testAddress", "testDistrict");
        testAddress.setAddress("replacedAddress");
        Assertions.assertEquals("replacedAddress", testAddress.getAddress(), "address not set.");
    }
    @Test
    public void testGetDistrict(){
        Address testAddress = new Address("testAddress", "testDistrict");
        testAddress.getDistrict();
        Assertions.assertEquals("testDistrict", testAddress.getDistrict(), "district not found.");
    }
    @Test
    public void testSetDistrict(){
        Address testAddress = new Address("testAddress", "testDistrict");
        testAddress.setDistrict("replacedDistrict");
        Assertions.assertEquals("replacedDistrict", testAddress.getDistrict(), "district not set.");
    }

}
