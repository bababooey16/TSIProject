package com.tsi.pedro.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class updateShopperStepsDef {

    Shopper updatedShopper;
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

    @Given("I have the shopper information to update")
    public void i_have_the_shopper_information_to_update() {

        updatedShopper = new Shopper("testShopperFirst","testShopperLast");
        updatedShopper.setShopper_id(1);
    }
    Shopper Actual;
    Shopper expected;
    @When("I send the update request")
    public void i_send_the_update_request() {
        setUp();
        when(shopperRepository.findById(1)).thenReturn(Optional.of(updatedShopper));
        String firstName = "updatedName";
        String lastName = "updatedLName";
        Actual = microServiceProjectApplication.Update_Shopper(updatedShopper.getShopper_id(), firstName, lastName).getBody();

    }
    @Then("I get the updated return string")
    public void i_get_the_updated_return_string() {

        ArgumentCaptor<Shopper> shopperArgumentCaptor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(shopperArgumentCaptor.capture());
        expected = shopperArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Shopper not updated");
    }









}
