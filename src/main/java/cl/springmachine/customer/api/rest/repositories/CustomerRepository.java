package cl.springmachine.customer.api.rest.repositories;

import cl.springmachine.customer.api.rest.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
