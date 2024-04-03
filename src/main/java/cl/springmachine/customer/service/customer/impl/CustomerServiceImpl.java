package cl.springmachine.customer.service.customer.impl;

import cl.springmachine.customer.repository.CustomerRepository;
import cl.springmachine.customer.repository.model.CustomerEntity;
import cl.springmachine.customer.service.customer.CustomerService;
import cl.springmachine.customer.service.customer.dto.CustomerCreateRequestDTO;
import cl.springmachine.customer.service.customer.dto.CustomerResponseDTO;
import cl.springmachine.customer.service.customer.dto.CustomerUpdateRequestDTO;
import cl.springmachine.customer.service.customer.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerResponseDTO> getAll() {
        return customerRepository.findAll().stream().map(CustomerMapper.INSTANCE::toCustomerResponseDTO).toList();
    }

    @Override
    public CustomerResponseDTO get(Integer id) {
        Optional<CustomerEntity> optional = customerRepository.findById(id);
        return optional.map(CustomerMapper.INSTANCE::toCustomerResponseDTO).orElse(null);
    }

    @Override
    public CustomerResponseDTO save(CustomerCreateRequestDTO request) {
        CustomerEntity entity = customerRepository.save(CustomerMapper.INSTANCE.toEntity(request));
        return CustomerMapper.INSTANCE.toCustomerResponseDTO(entity);
    }

    @Override
    public CustomerResponseDTO update(CustomerUpdateRequestDTO request, Integer id) {
        Optional<CustomerEntity> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            CustomerEntity entity = optional.get();
            updateFieldIfNotNull(request.getFirstName(), entity::setFirstName);
            updateFieldIfNotNull(request.getLastName(), entity::setLastName);
            updateFieldIfNotNull(request.getDocumentType(), entity::setDocumentType);
            updateFieldIfNotNull(request.getDocumentId(), entity::setDocumentId);
            updateFieldIfNotNull(request.getPhone(), entity::setPhone);
            updateFieldIfNotNull(request.getEmail(), entity::setEmail);
            updateFieldIfNotNull(request.getAddressId(), entity::setAddressId);
            updateFieldIfNotNull(request.getInvoiceDataId(), entity::setInvoiceDataId);
            updateFieldIfNotNull(request.getCustomerType(), entity::setCustomerType);
            updateFieldIfNotNull(request.getLegalName(), entity::setLegalName);
            updateFieldIfNotNull(request.getClassification(), entity::setClassification);
            customerRepository.save(entity);
            return get(id);
        }
        return null;
    }

    private <T> void updateFieldIfNotNull(T value, Consumer<T> setter) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
