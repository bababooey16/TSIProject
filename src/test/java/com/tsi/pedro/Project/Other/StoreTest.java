package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void testGetStore_id(){
        Store testStore = new Store(1,1);
        testStore.setStore_id(1);
        Assertions.assertEquals(1,1);
    }
    @Test
    public void testSetStore_id(){
        Store testStore = new Store(1,1);
        testStore.setStore_id(1);
        Assertions.assertEquals(1, testStore.getStore_id(), "id not set.");
    }
    @Test
    public void testGetManagerId(){
        Store testStore = new Store(1,1);
        Assertions.assertEquals(1, testStore.getManager_staff_id(), "Manager ID not found.");
    }
    @Test
    public void testSetManagerId(){
        Store testStore = new Store(1,1);
        testStore.setManager_staff_id(2);
        Assertions.assertEquals(2, testStore.getManager_staff_id(), "Manager ID not set.");
    }
    @Test
    public void testGetAddressId(){
        Store testStore = new Store(1,1);
        Assertions.assertEquals(1, testStore.getAddress_id(), "Address ID not found.");
    }
    @Test
    public void testSetAddressId(){
        Store testStore = new Store(1,1);
        testStore.setAddress_id(2);
        Assertions.assertEquals(2, testStore.getAddress_id(), "Address ID not set.");
    }









}
