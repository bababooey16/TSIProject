package com.tsi.pedro.Project;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MicroServiceProjectApplication {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";

	public MicroServiceProjectApplication(ActorRepository actorRepository, CustomerRepository customerRepository, AddressRepository addressRepository){
		this.actorRepository = actorRepository;
		this.customerRepository = customerRepository;
		this.addressRepository= addressRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjectApplication.class, args);
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody
	String Add_Actor(@RequestParam String first_name, @RequestParam String last_name){
		Actor Add_Actor = new Actor(first_name,last_name);
		actorRepository.save(Add_Actor);
		return saved;
	}
	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String Delete_Actor(@RequestParam int actor_id){
		actorRepository.deleteById(actor_id);
		return deleted;
	}
	@PutMapping("/Update_Actor")
	public ResponseEntity<Actor> Update_Actor (@RequestParam int actor_id, String first_name, String last_name) {
		Actor Update_Actor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for " + actor_id));
		Update_Actor.setFirst_name(first_name);
		Update_Actor.setLast_name(last_name);
		actorRepository.save(Update_Actor);
		return ResponseEntity.ok(Update_Actor);
	}


	@GetMapping("/All_Customers")
	public @ResponseBody
	Iterable<Customer>getAllCustomers(){
		return customerRepository.findAll();
	}



	@GetMapping("/All_Addresses")
	public @ResponseBody
	Iterable<Address>getAllAddresses(){
		return addressRepository.findAll();
	}









}
