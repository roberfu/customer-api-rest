package cl.springmachine.customer.api.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.dtos.CustomerUpdateRequestDto;
import cl.springmachine.customer.api.rest.services.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	ResponseEntity<Iterable<CustomerResponseDto>> findCustomer() {
		return new ResponseEntity<>(customerService.findCustomers(), HttpStatus.OK);
	}

	@PostMapping
	@Validated
	ResponseEntity<CustomerResponseDto> saveCustomer(@Valid @RequestBody CustomerCreateRequestDto requestDto) {
		return new ResponseEntity<>(customerService.saveCustomer(requestDto), HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	ResponseEntity<Void> saveCustomer(@RequestBody CustomerUpdateRequestDto requestDto, @PathVariable Integer id) {
		customerService.updateCustomer(requestDto, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
