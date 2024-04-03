package cl.springmachine.customer.repository;

import cl.springmachine.customer.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>,
        JpaSpecificationExecutor<CustomerEntity> {
}
