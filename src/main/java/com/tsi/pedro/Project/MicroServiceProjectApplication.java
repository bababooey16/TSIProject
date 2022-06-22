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
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private StoreRepository storeRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";
	private int randomCustomer;
	private int customerAddressID;

	public MicroServiceProjectApplication(ShopperRepository shopperRepository, CustomerRepository customerRepository, AddressRepository addressRepository, FilmRepository filmRepository, InventoryRepository inventoryRepository, RentalRepository rentalRepository, StaffRepository staffRepository, StoreRepository storeRepository ){
		this.shopperRepository = shopperRepository;
		this.customerRepository = customerRepository;
		this.addressRepository= addressRepository;
		this.filmRepository = filmRepository;
		this.inventoryRepository=inventoryRepository;
		this.rentalRepository=rentalRepository;
		this.staffRepository=staffRepository;
		this.storeRepository=storeRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjectApplication.class, args);
	}

	//SHOPPER MAPPING
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
		Shopper update_Shopper = shopperRepository.findById(shopper_id).orElseThrow(() -> new ResourceNotFoundException("Shopper not found for " + shopper_id));
		update_Shopper.setFirst_name(first_name);

//		update_Shopper.setCredit_card(credit_card);
//		update_Shopper.setExpire_date(expire_date);
//		update_Shopper.setCvc_code(cvc_code);
		update_Shopper.setCustomer_id(customer_id);
		shopperRepository.save(update_Shopper);
		return ResponseEntity.ok(update_Shopper);
	}

	//CUSTOMER MAPPING
	@GetMapping("/All_Customers")
	public @ResponseBody
	Iterable<Customer>getAllCustomers(){
		return customerRepository.findAll();
	}

	@GetMapping("/Get_A_Customer")
	public ResponseEntity<Customer>getACustomer(@RequestParam(required = false) int customer_id){
		if (randomCustomer != 0){
			customer_id = randomCustomer;}

		Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with ID "));
		customerAddressID = customer.getAddress_id();
		return ResponseEntity.ok(customer);

	}

	//ADDRESS MAPPING
	@GetMapping("/All_Addresses")
	public @ResponseBody
	Iterable<Address>getAllAddresses(){
		return addressRepository.findAll();
	}

	@GetMapping("/Get_An_Address")
	public ResponseEntity<Address>getAnAddress(@RequestParam(required = false) int address_id){
		if (customerAddressID != 0){
		address_id = customerAddressID;}
		Address address = addressRepository.findById(address_id).orElseThrow(() -> new ResourceNotFoundException("Address does not exist with ID"));
		return ResponseEntity.ok(address);
	}

	//FILM MAPPING
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/Get_A_Film")
	public ResponseEntity<Film>getAFilm(@RequestParam int film_id){
		Film film = filmRepository.findById(film_id).orElseThrow(() -> new ResourceNotFoundException("Film does not exist with ID" +film_id));
		return ResponseEntity.ok(film);
}


	//INVENTORY MAPPING

	@GetMapping("/All_Inventory")
	public @ResponseBody
	Iterable<Inventory>getAllInventory() {return inventoryRepository.findAll();}

	@GetMapping("/Get_An_Inventory")
	public ResponseEntity<Inventory>getAnInventory(@RequestParam int inventory_id){
		Inventory inventory = inventoryRepository.findById(inventory_id).orElseThrow(() -> new ResourceNotFoundException("Inventory id does not exist:" +inventory_id ));
		return ResponseEntity.ok(inventory);
	}

	//RENTAL MAPPING
	@GetMapping("/All_Rental")
	public @ResponseBody
	Iterable<Rental>getAllRental() {return rentalRepository.findAll();}

	@GetMapping("/Get_A_Rental")
	public ResponseEntity<Rental>getAnRental(@RequestParam int rental_id){
		Rental rental = rentalRepository.findById(rental_id).orElseThrow(() -> new ResourceNotFoundException("Rental id does not exist:" +rental_id ));
		return ResponseEntity.ok(rental);
	}

	//STAFF MAPPING

	@GetMapping("/All_Staff")
	public @ResponseBody
	Iterable<Staff>getAllStaff() {return staffRepository.findAll();}

	@GetMapping("/Get_A_Staff")
	public ResponseEntity<Staff>getAnStaff(@RequestParam int staff_id){
		Staff staff = staffRepository.findById(staff_id).orElseThrow(() -> new ResourceNotFoundException("Staff id does not exist:" +staff_id ));
		return ResponseEntity.ok(staff);
	}


	//STORE MAPPING
	@GetMapping("/All_Store")
	public @ResponseBody
	Iterable<Store>getAllStore() {return storeRepository.findAll();}

	@GetMapping("/Get_A_Store")
	public ResponseEntity<Store>getAnStore(@RequestParam int store_id){
		Store store = storeRepository.findById(store_id).orElseThrow(() -> new ResourceNotFoundException("Store id does not exist:" +store_id ));
		return ResponseEntity.ok(store);
	}
}

