package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.Shopper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopperTest {

    @Test
    public void testGetShopper_id(){
        Shopper testShopper = new Shopper("testFName", 1239874589765476L,"05/05",306,69);
        testShopper.setShopper_id(1);
        Assertions.assertEquals(1, testShopper.getShopper_id(), "id not found.");
    }
    @Test
    public void testSetShopper_id(){
        Shopper testShopper = new Shopper("testFName", 123757587546876L,"05/05",306,69);
        testShopper.setShopper_id(1);
        Assertions.assertEquals(1, testShopper.getShopper_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Shopper testShopper = new Shopper("testFName", 12365465464654L,"05/05",306,69);
        Assertions.assertEquals("testFName", testShopper.getFirst_name(), "first name not found.");
    }
    @Test
    public void testSetFirst_name(){
        Shopper testShopper = new Shopper("testFName", 12876453645673L,"05/05",306,69);
        testShopper.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testShopper.getFirst_name(), "first name not set.");
    }






}
