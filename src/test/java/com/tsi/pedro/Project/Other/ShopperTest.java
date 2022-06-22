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

    @Test
    public void testGetCredit_Card(){
        Shopper testShopper = new Shopper("testFName", 12365465464654L,"05/05",306,69);
        Assertions.assertEquals(12365465464654L, testShopper.getCredit_card(), "credit card not found.");
    }

    @Test
    public void testSetCredit_Card(){
        Shopper testShopper = new Shopper("testFName", 12876453645673L,"05/05",306,69);
        testShopper.setCredit_card(6757467456487564857L);
        Assertions.assertEquals(6757467456487564857L, testShopper.getCredit_card(), "card not set.");
    }
    @Test
    public void testGetExpire_date(){
        Shopper testShopper = new Shopper("testFName", 12365465464654L,"05/05",306,69);
        Assertions.assertEquals("05/05", testShopper.getExpire_date(), "date not found.");
    }
    @Test
    public void testSetExpire_Date(){
        Shopper testShopper = new Shopper("testFName", 12876453645673L,"05/05",306,69);
        testShopper.setExpire_date("06/06");
        Assertions.assertEquals("06/06", testShopper.getExpire_date(), "date not set.");
    }
    @Test
    public void testGetCvc_Code(){
        Shopper testShopper = new Shopper("testFName", 12365465464654L,"05/05",306,69);
        Assertions.assertEquals(306, testShopper.getCvc_code(), "code not found.");
    }
    @Test
    public void testSetCvc_Code(){
        Shopper testShopper = new Shopper("testFName", 12876453645673L,"05/05",306,69);
        testShopper.setCvc_code(505);
        Assertions.assertEquals(505, testShopper.getCvc_code(), "code not set.");
    }
    @Test
    public void testGetCustomer_Id(){
        Shopper testShopper = new Shopper("testFName", 12365465464654L,"05/05",306,69);
        Assertions.assertEquals(69, testShopper.getCustomer_id(), "ID not found.");
    }
    @Test
    public void testSetCustomer_Id(){
        Shopper testShopper = new Shopper("testFName", 12876453645673L,"05/05",306,69);
        testShopper.setCustomer_id(29);
        Assertions.assertEquals(29, testShopper.getCustomer_id(), "ID not set.");
    }
}
