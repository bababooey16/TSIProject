package com.tsi.pedro.Project;


import org.apache.maven.wagon.ResourceDoesNotExistException;
import org.hibernate.sql.Update;
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
    private ActorRepository actorRepository;
    @Mock
    private AddressRepository addressRepository;

    int actor_id;
    @BeforeEach
    void setUp(){
        microServiceProjectApplication = new MicroServiceProjectApplication(actorRepository, customerRepository, addressRepository);
    }

    @Test
    public void getAllActors(){
        microServiceProjectApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void testAddActor(){
        Actor SavedActor = new Actor("testActorFirst","testActorLast");
        String expected = "Saved";
        String Actual = microServiceProjectApplication.Add_Actor(SavedActor.getFirst_name(),SavedActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor is not saved into the database");

    }
    @Test
    public void testDeleteActor() {
        Actor DeletedActor = new Actor("testActorFirst", "testActorLast");
        DeletedActor.setActor_id(1);
        String Actual = microServiceProjectApplication.Delete_Actor(1);
        String expected = "Deleted";
        ArgumentCaptor<Integer> actorArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Actor not deleted");
    }

    @Test
    public void testUpdateActor() throws ResourceDoesNotExistException {
        Actor UpdateActor = new Actor("testActorFirst", "testActorLast");
        UpdateActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(UpdateActor));
        Actor Actual = microServiceProjectApplication.Update_Actor(UpdateActor.getActor_id(), UpdateActor.getFirst_name(), UpdateActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
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
