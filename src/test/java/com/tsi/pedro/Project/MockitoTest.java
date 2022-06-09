package com.tsi.pedro.Project;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    MicroServiceProjectApplication microServiceProjectApplication;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ShopperRepository shopperRepository;
    @Mock
    private AddressRepository addressRepository;

    int shopper_id;
    @BeforeEach
    void setUp(){
        microServiceProjectApplication = new MicroServiceProjectApplication(shopperRepository, customerRepository, addressRepository);
    }

    @Test
    public void getAllShoppers(){
        microServiceProjectApplication.getAllShoppers();
        verify(shopperRepository).findAll();
    }

    @Test
    public void testAddShopper(){
        Shopper savedShopper = new Shopper("testShopperFirst","testShopperLast");
        String expected = "Saved";
        String Actual = microServiceProjectApplication.Add_Shopper(savedShopper.getFirst_name(), savedShopper.getLast_name());
        ArgumentCaptor<Shopper> shopperArgumentCaptor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(shopperArgumentCaptor.capture());
        shopperArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Shopper is not saved into the database");

    }
    @Test
    public void testDeleteShopper() {
        Shopper deletedShopper = new Shopper("testShopperFirst", "testShopperLast");
        deletedShopper.setShopper_id(1);
        String Actual = microServiceProjectApplication.Delete_Shopper(1);
        String expected = "Deleted";
        ArgumentCaptor<Integer> shopperArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(shopperRepository).deleteById(shopperArgumentCaptor.capture());
        shopperArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Shopper not deleted");
    }

    @Test
    public void testUpdateShopper() {
        Shopper updateShopper = new Shopper("testShopperFirst", "testShopperLast");
        updateShopper.setShopper_id(1);
        when(shopperRepository.findById(1)).thenReturn(Optional.of(updateShopper));
        Shopper Actual = microServiceProjectApplication.Update_Shopper(updateShopper.getShopper_id(), updateShopper.getFirst_name(), updateShopper.getLast_name()).getBody();
        ArgumentCaptor<Shopper> shopperArgumentCaptor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(shopperArgumentCaptor.capture());
        Shopper Expected = shopperArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Shopper was not updated.");
    }

    @Test
    public void getAllCustomers(){
        microServiceProjectApplication.getAllCustomers();
        verify(customerRepository).findAll();
    }

//    @Test
//    public void testAddCustomer(){
//
//        Customer SavedCustomer = new Customer("testCustomerFirst","testCustomerLast","testCustomerEmail");
//
//        String expected = "Saved";
//
//        String Actual = microServiceProjectApplication.Add_Customer(SavedCustomer.getFirst_name(),SavedCustomer.getLast_name(), SavedCustomer.getEmail());
//
//        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
//
//        verify(customerRepository).save(customerArgumentCaptor.capture());
//
//        customerArgumentCaptor.getValue();
//
//        Assertions.assertEquals(expected,Actual,"Customer is not saved into the database");
//
//    }

    @Test
    public void getAllAddresses(){
        microServiceProjectApplication.getAllAddresses();
        verify(addressRepository).findAll();
    }














}
