package com.tsi.pedro.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class deleteShopperStepsDef {

    Shopper deletedShopper;
    private MicroServiceProjectApplication microServiceProjectApplication;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ShopperRepository shopperRepository;
    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setUp(){
        shopperRepository =mock(ShopperRepository.class);
        customerRepository=mock(CustomerRepository.class);
        addressRepository=mock(AddressRepository.class);
        microServiceProjectApplication = new MicroServiceProjectApplication(shopperRepository, customerRepository, addressRepository);
    }

    @Given("I have the shopper information for deletion")
    public void i_have_the_shopper_information_for_deletion() {

        deletedShopper = new Shopper("testShopperFirst","testShopperLast",123,69);
        deletedShopper.setShopper_id(1);
    }

    String Actual;
    @When("I send the delete request")
    public void i_send_the_delete_request() {
        setUp();
        Actual = microServiceProjectApplication.Delete_Shopper(1);

    }
    @Then("I get the deleted return string")
    public void i_get_the_deleted_return_string(){
        String expected = "Deleted";
        ArgumentCaptor<Integer>shopperArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(shopperRepository).deleteById(shopperArgumentCaptor.capture());
        shopperArgumentCaptor.getValue();

        Assertions.assertEquals(expected, Actual);

    }

}
