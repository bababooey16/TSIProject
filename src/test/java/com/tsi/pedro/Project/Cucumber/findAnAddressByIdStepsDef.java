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

public class findAnAddressByIdStepsDef {
    Address findAddress;
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

    Address Actual;
    @Given("I have the address id number")
    public void i_have_the_address_id_number() {
        findAddress = new Address("addresstest", "districttest", 756574684545768L);
        findAddress.setAddress_id(1);
    }
    @When("I input the address id into the search")
    public void i_input_the_address_id_into_the_search() {
        setUp();
        when(addressRepository.findById(1)).thenReturn(Optional.of(findAddress));
        Actual = microServiceProjectApplication.getAnAddress(findAddress.getAddress_id()).getBody();
    }
    @Then("I get the returned address information")
    public void i_get_the_returned_address_information() {
        Address expected;
        expected = findAddress;
        Assertions.assertEquals(expected, Actual, "Could not find address by ID");
    }
}
