package com.tsi.pedro.Project.Cucumber;

import com.tsi.pedro.Project.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class findCustomerByIdStepsDef {

    Customer findCustomer;
    private MicroServiceProjectApplication microServiceProjectApplication;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ShopperRepository shopperRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private InventoryRepository inventoryRepository;
    @Mock
    private RentalRepository rentalRepository;
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp(){
        shopperRepository =mock(ShopperRepository.class);
        customerRepository=mock(CustomerRepository.class);
        addressRepository=mock(AddressRepository.class);
        filmRepository=mock(FilmRepository.class);
        inventoryRepository=mock(InventoryRepository.class);
        rentalRepository=mock(RentalRepository.class);
        staffRepository=mock(StaffRepository.class);
        storeRepository=mock(StoreRepository.class);
        microServiceProjectApplication = new MicroServiceProjectApplication(shopperRepository, customerRepository, addressRepository, filmRepository, inventoryRepository, rentalRepository, staffRepository, storeRepository);
    }

    Customer Actual;


    @Given("I have the customer id number")
    public void i_have_the_customer_id_number() {

        findCustomer = new Customer("firstname", "lastname", "bingbongemail@yep.com", 6);
        findCustomer.setCustomer_id(1);
    }
    @When("I input the id into the customer search")
    public void i_input_the_id_into_the_customer_search() {
        setUp();
        when(customerRepository.findById(1)).thenReturn(Optional.of(findCustomer));
        Actual = microServiceProjectApplication.getACustomer(findCustomer.getCustomer_id()).getBody();
    }
    @Then("I get the returned customers information")
    public void i_get_the_returned_customers_information() {
        Customer expected;
        expected = findCustomer;
        Assertions.assertEquals(expected, Actual, "Could not find customer by ID");
    }
}
