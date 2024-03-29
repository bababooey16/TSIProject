package com.tsi.pedro.Project.Cucumber;

import com.tsi.pedro.Project.*;
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

    @Given("I have the shopper information to update")
    public void i_have_the_shopper_information_to_update() {

        updatedShopper = new Shopper("testShopperFirst",12387453867L,"05/05",306,null);
        updatedShopper.setShopper_id(1);
    }
    Shopper Actual;
    Shopper expected;
    @When("I send the update request")
    public void i_send_the_update_request() {
        setUp();
        when(shopperRepository.findById(1)).thenReturn(Optional.of(updatedShopper));
        String firstName = "updatedName";
        long creditcard = 1234565436543L;
        String expiredate = "0305";
        int cvccode = 309;
        Integer customerid = 30;
        Actual = microServiceProjectApplication.Update_Shopper(updatedShopper.getShopper_id(), firstName, creditcard, expiredate, cvccode, customerid).getBody();

    }
    @Then("I get the updated return string")
    public void i_get_the_updated_return_string() {

        ArgumentCaptor<Shopper> shopperArgumentCaptor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(shopperArgumentCaptor.capture());
        expected = shopperArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Shopper not updated");
    }









}
