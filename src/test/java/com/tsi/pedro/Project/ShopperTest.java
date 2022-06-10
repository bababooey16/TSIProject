package com.tsi.pedro.Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopperTest {

    @Test
    public void testGetShopper_id(){
        Shopper testShopper = new Shopper("testFName", "testLName",1239874589765476L,69);
        testShopper.setShopper_id(1);
        Assertions.assertEquals(1, testShopper.getShopper_id(), "id not found.");
    }
    @Test
    public void testSetShopper_id(){
        Shopper testShopper = new Shopper("testFName", "testLName",123757587546876L,69);
        testShopper.setShopper_id(1);
        Assertions.assertEquals(1, testShopper.getShopper_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Shopper testShopper = new Shopper("testFName", "testLName",12365465464654L,69);
        Assertions.assertEquals("testFName", testShopper.getFirst_name(), "first name not found.");
    }
    @Test
    public void testSetFirst_name(){
        Shopper testShopper = new Shopper("testFName", "testLName",12876453645673L,69);
        testShopper.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testShopper.getFirst_name(), "first name not set.");
    }
    @Test
    public void testGetLast_name(){
        Shopper testShopper = new Shopper("testFName", "testLName",125537547634567L,69);
        testShopper.getLast_name();
        Assertions.assertEquals("testLName", testShopper.getLast_name(), "last name not found.");
    }
    @Test
    public void testSetLast_name(){
        Shopper testShopper = new Shopper("testFName", "testLName",12344343434455L,69);
        testShopper.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testShopper.getLast_name(), "last name not set.");
    }




}
