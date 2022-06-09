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

public class updateActorStepsDef {

    Actor UpdatedActor;
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

    @Given("I have the actor information to update")
    public void i_have_the_actor_information_to_update() {

        UpdatedActor = new Actor("testActorFirst","testActorLast");
        UpdatedActor.setActor_id(1);
    }
    Actor Actual;
    Actor expected;
    @When("I send the update request")
    public void i_send_the_update_request() {
        setUp();
        when(actorRepository.findById(1)).thenReturn(Optional.of(UpdatedActor));
        String firstName = "updatedName";
        String lastName = "updatedLName";
        Actual = microServiceProjectApplication.Update_Actor(UpdatedActor.getActor_id(), firstName, lastName).getBody();

    }
    @Then("I get the updated return string")
    public void i_get_the_updated_return_string() {

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Actor not updated");
    }









}
