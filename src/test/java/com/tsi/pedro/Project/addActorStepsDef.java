package com.tsi.pedro.Project;

import com.tsi.pedro.Project.*;
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
public class addActorStepsDef {
    Actor SavedActor;
    private MicroServiceProjectApplication microServiceProjectApplication;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setUp(){
        actorRepository=mock(ActorRepository.class);
        customerRepository=mock(CustomerRepository.class);
        addressRepository=mock(AddressRepository.class);
        microServiceProjectApplication = new MicroServiceProjectApplication(actorRepository, customerRepository, addressRepository);
    }

    @Given("I have the actor information")
    public void i_have_the_actor_information() {

        SavedActor = new Actor("testActorFirst","testActorLast");


    }
    String Actual;
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        setUp();
        Actual = microServiceProjectApplication.Add_Actor(SavedActor.getFirst_name(), SavedActor.getLast_name());
    }


    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // check for return

        String expected = "Saved";
        ArgumentCaptor<Actor> reviewArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Actor not added");

    }












}
