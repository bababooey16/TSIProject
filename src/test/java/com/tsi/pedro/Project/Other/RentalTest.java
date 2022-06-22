package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    public void testGetRentalID(){
        Rental testRental = new Rental(1, 1, 1);
        testRental.setRental_id(1);
        Assertions.assertEquals(1, testRental.getRental_id(), "id not found.");
    }
    @Test
    public void testSetRental_Id(){
        Rental testRental = new Rental(1,1,1);
        testRental.setRental_id(2);
        Assertions.assertEquals(2, testRental.getRental_id(), "id not set.");
    }
    @Test
    public void testGetInventoryId(){
        Rental testRental = new Rental(1,1,1);
        Assertions.assertEquals(1, testRental.getInventory_id(), "inventory not found.");
    }
    @Test
    public void testSetInventoryId(){
        Rental testRental = new Rental(1,1,1);
        testRental.setInventory_id(2);
        Assertions.assertEquals(2, testRental.getInventory_id(), "inventory ID not set.");
    }
    @Test
    public void testGetCustomer(){
        Rental testRental = new Rental(1,1,1);
        Assertions.assertEquals(1, testRental.getCustomer_id(), "customer not found.");
    }
    @Test
    public void testSetCustomerID(){
        Rental testRental = new Rental(1,1,1);
        testRental.setCustomer_id(2);
        Assertions.assertEquals(2, testRental.getCustomer_id(), "customer ID not set.");
    }
    @Test
    public void testGetStaffId(){
        Rental testRental = new Rental(1,1,1);
        Assertions.assertEquals(1, testRental.getStaff_id(), "staff not found.");
    }
    @Test
    public void testSetStaffId(){
        Rental testRental = new Rental(1,1,1);
        testRental.setStaff_id(2);
        Assertions.assertEquals(2, testRental.getStaff_id(), "staff ID not set.");
    }




}
