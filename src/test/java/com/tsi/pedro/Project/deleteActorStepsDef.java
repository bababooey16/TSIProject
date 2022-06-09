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

public class deleteActorStepsDef {

    Actor DeletedActor;
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

    @Given("I have the actor information for deletion")
    public void i_have_the_actor_information_for_deletion() {

        DeletedActor = new Actor("testActorFirst","testActorLast");
        DeletedActor.setActor_id(1);
    }

    String Actual;
    @When("I send the delete request")
    public void i_send_the_delete_request() {
        setUp();
        Actual = microServiceProjectApplication.Delete_Actor(1);

    }
    @Then("I get the deleted return string")
    public void i_get_the_deleted_return_string(){
        String expected = "Deleted";
        ArgumentCaptor<Integer>actorArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, Actual);

    }

}
