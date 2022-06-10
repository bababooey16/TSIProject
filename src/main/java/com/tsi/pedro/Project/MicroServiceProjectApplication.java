package com.tsi.pedro.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MicroServiceProjectApplication {

	@Autowired
	private ShopperRepository shopperRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";

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
	public @ResponseBody
	String Add_Shopper(@RequestParam String first_name, @RequestParam String last_name, @RequestParam long credit_card, @RequestParam int customer_id){
		Shopper add_Shopper = new Shopper(first_name,last_name, credit_card, customer_id);
		shopperRepository.save(add_Shopper);
		return saved;
	}
	@DeleteMapping("/Delete_Shopper")
	public @ResponseBody String Delete_Shopper(@RequestParam int shopper_id){
		shopperRepository.deleteById(shopper_id);
		return deleted;
	}
	@PutMapping("/Update_Shopper")
	public ResponseEntity<Shopper> Update_Shopper (@RequestParam int shopper_id, String first_name, String last_name, long credit_card, int customer_id) {
		Shopper update_Shopper = shopperRepository.findById(shopper_id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for " + shopper_id));
		update_Shopper.setFirst_name(first_name);
		update_Shopper.setLast_name(last_name);
		update_Shopper.setCredit_card(credit_card);
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
	public ResponseEntity<Customer>getACustomer(@RequestParam int customer_id){
		Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("Shopper does not exist with ID: " +customer_id));
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
