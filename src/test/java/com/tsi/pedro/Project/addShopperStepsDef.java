package com.tsi.pedro.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class addShopperStepsDef {
    Shopper savedShopper;
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

    @Given("I have the shopper information")
    public void i_have_the_shopper_information() {

        savedShopper = new Shopper("testShopperFirst",16543654323L,"03/03",803,69);


    }
    String Actual;
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        setUp();
        Actual = microServiceProjectApplication.Add_Shopper(savedShopper.getFirst_name(), savedShopper.getCredit_card(), savedShopper.getExpire_date(), savedShopper.getCvc_code(), savedShopper.getCustomer_id());
    }


    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // check for return

        String expected = "Saved";
        ArgumentCaptor<Shopper> shopperArgumentCaptor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(shopperArgumentCaptor.capture());
        shopperArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Shopper not added");

    }












}
