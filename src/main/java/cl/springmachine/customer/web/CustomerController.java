package cl.springmachine.customer.web;

import cl.springmachine.customer.service.customer.CustomerService;
import cl.springmachine.customer.service.customer.dto.CustomerCreateRequestDTO;
import cl.springmachine.customer.service.customer.dto.CustomerResponseDTO;
import cl.springmachine.customer.service.customer.dto.CustomerUpdateRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<List<CustomerResponseDTO>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<CustomerResponseDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.get(id), HttpStatus.OK);
    }

    @PostMapping
    @Validated
    ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerCreateRequestDTO request) {
        return new ResponseEntity<>(customerService.save(request), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<CustomerResponseDTO> update(@RequestBody CustomerUpdateRequestDTO request,
                                               @PathVariable Integer id) {
        return new ResponseEntity<>(customerService.update(request, id), HttpStatus.OK);
    }

}
