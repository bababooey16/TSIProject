package com.tsi.pedro.Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    public void testGetActor_id(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id not found.");
    }
    @Test
    public void testSetActor_id(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id not set.");
    }
    @Test
    public void testGetFirst_name(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        Assertions.assertEquals("testAddress", testActor.getFirst_name(), "address not found.");
    }
    @Test
    public void testSetFirst_name(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        testActor.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testActor.getFirst_name(), "address not set.");
    }
    @Test
    public void testGetLast_name(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        testActor.getLast_name();
        Assertions.assertEquals("testDistrictame", testActor.getLast_name(), "district not found.");
    }
    @Test
    public void testSetLast_name(){
        Actor testActor = new Actor("testAddress", "testDistrict");
        testActor.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testActor.getLast_name(), "district not set.");
    }

}
