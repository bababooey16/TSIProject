package com.tsi.pedro.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class MicroServiceProjectApplication {



	@Autowired
	private ShopperRepository shopperRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";
	private int randomCustomer;

	public MicroServiceProjectApplication(ShopperRepository shopperRepository, CustomerRepository customerRepository, AddressRepository addressRepository){
		this.shopperRepository = shopperRepository;
		this.customerRepository = customerRepository;
		this.addressRepository= addressRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjectApplication.class, args);
	}

	@GetMapping("/All_Shoppers")
	public @ResponseBody
	Iterable<Shopper>getAllShoppers(){
		return shopperRepository.findAll();
	}
	@GetMapping("/Get_A_Shopper")
	public ResponseEntity<Shopper>getAShopper(@RequestParam int shopper_id){
		Shopper shopper = shopperRepository.findById(shopper_id).orElseThrow(() -> new ResourceNotFoundException("Shopper does not exist with ID: " +shopper_id));
		return ResponseEntity.ok(shopper);
	}


	@PostMapping("/Add_Shopper")
	public @ResponseBody String Add_Shopper(@RequestBody Shopper shopper){
		SecureRandom randCustomer = new SecureRandom();
		randomCustomer = randCustomer.nextInt(1,599);
		shopper.setCustomer_id(randomCustomer);
		shopperRepository.save(shopper);

		return saved;
	}
	@DeleteMapping("/Delete_Shopper")
	public @ResponseBody String Delete_Shopper(@RequestParam int shopper_id){
		shopperRepository.deleteById(shopper_id);
		return deleted;
	}
	@PutMapping("/Update_Shopper")
	public ResponseEntity<Shopper> Update_Shopper (@RequestParam int shopper_id, String first_name,  long credit_card, String expire_date, int cvc_code, Integer customer_id) {
		Shopper update_Shopper = shopperRepository.findById(shopper_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for " + shopper_id));
		update_Shopper.setFirst_name(first_name);

//		update_Shopper.setCredit_card(credit_card);
//		update_Shopper.setExpire_date(expire_date);
//		update_Shopper.setCvc_code(cvc_code);
		update_Shopper.setCustomer_id(customer_id);
		shopperRepository.save(update_Shopper);
		return ResponseEntity.ok(update_Shopper);
	}


	@GetMapping("/All_Customers")
	public @ResponseBody
	Iterable<Customer>getAllCustomers(){
		return customerRepository.findAll();
	}

	@GetMapping("/Get_A_Customer")
	public ResponseEntity<Customer>getACustomer(@RequestParam(required = false) int customer_id){
		if (randomCustomer != 0){
			customer_id = randomCustomer;}
		System.out.println(customer_id);
		Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with ID: "));
		return ResponseEntity.ok(customer);
	}

	@GetMapping("/All_Addresses")
	public @ResponseBody
	Iterable<Address>getAllAddresses(){
		return addressRepository.findAll();
	}

	@GetMapping("/Get_An_Address")
	public ResponseEntity<Address>getAnAddress(@RequestParam int address_id){
		Address address = addressRepository.findById(address_id).orElseThrow(() -> new ResourceNotFoundException("Shopper does not exist with ID: " +address_id));
		return ResponseEntity.ok(address);
	}








}
