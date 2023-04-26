package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(allowedHeaders = "*",origins="*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	//Api for retrieval
	@GetMapping("/customer")
	 public List<Customer> list() {
        return service.listAll();
    }
	
	@GetMapping("/customer/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
        	Customer customer = service.get(id);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }      
    }
	
	//Api for creating
	 @PostMapping("/customer")
	    public void add(@RequestBody Customer customer) {
	        service.save(customer);
	    }
	 
	 //Api for updating
	 @PutMapping("/customer/{id}")
	    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
	        try {
	        	@SuppressWarnings("unused")
				Customer existCustomer = service.get(id);
	            service.save(customer);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }      
	    }
	 
	 //Api for deleting
	 @DeleteMapping("/customer/{id}")
	    public void delete(@PathVariable Integer id) {
	        service.delete(id);
	    }
		 
	
	
}
