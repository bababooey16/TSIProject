package com.tsi.pedro.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class findAShopperByIdStepsDef {

    Shopper findShopper;
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

    Shopper Actual;
    @Given("I have the shopper id number")
    public void i_have_the_shopper_id_number() {

        findShopper = new Shopper("firstname", "lastname", 3724657634243L, 17);
        findShopper.setShopper_id(1);
    }
    @When("I input the id into the search")
    public void i_input_the_id_into_the_search() {

        setUp();
        when(shopperRepository.findById(1)).thenReturn(Optional.of(findShopper));
        Actual = microServiceProjectApplication.getAShopper(findShopper.getShopper_id()).getBody();
    }
    @Then("I get the returned shoppers information")
    public void i_get_the_returned_shoppers_information() {

        Shopper expected;
        expected = findShopper;
        Assertions.assertEquals(expected, Actual, "Could not find shopper by ID");
    }
}
