package cl.springmachine.customer.service.customer;

import cl.springmachine.customer.service.customer.dto.CustomerCreateRequestDTO;
import cl.springmachine.customer.service.customer.dto.CustomerResponseDTO;
import cl.springmachine.customer.service.customer.dto.CustomerUpdateRequestDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseDTO> getAll();

    CustomerResponseDTO get(Integer id);

    CustomerResponseDTO save(CustomerCreateRequestDTO request);

    CustomerResponseDTO update(CustomerUpdateRequestDTO request, Integer id);
}
