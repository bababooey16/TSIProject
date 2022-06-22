package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testGetInventory(){
        Inventory testInv = new Inventory(1,1);
        testInv.setInventory_id(1);
        Assertions.assertEquals(1, testInv.getInventory_id(), "id not found.");
    }
    @Test
    public void testSetInventory_Id(){
        Inventory testInv = new Inventory(1,1);
        testInv.setInventory_id(2);
        Assertions.assertEquals(2, testInv.getInventory_id(), "id not set.");
    }
    @Test
    public void testGetFilmId(){
        Inventory testInv = new Inventory(1,1);
        Assertions.assertEquals(1, testInv.getFilm_id(), "film not found.");
    }
    @Test
    public void testSetFilmId(){
        Inventory testInv = new Inventory(1,1);
        testInv.setFilm_id(2);
        Assertions.assertEquals(2, testInv.getFilm_id(), "film ID not set.");
    }
    @Test
    public void testGetStoreId(){
        Inventory testInv = new Inventory(1,1);
        Assertions.assertEquals(1, testInv.getStore_id(), "store not found.");
    }
    @Test
    public void testSetStoreId(){
        Inventory testInv = new Inventory(1,1);
        testInv.setStore_id(2);
        Assertions.assertEquals(2, testInv.getStore_id(), "Store ID not set.");
    }











}
