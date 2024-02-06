package cl.springmachine.customer.api.rest.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.springmachine.customer.api.rest.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
