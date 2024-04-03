package cl.springmachine.customer.service.customer.mapper;

import cl.springmachine.customer.repository.model.CustomerEntity;
import cl.springmachine.customer.service.customer.dto.CustomerCreateRequestDTO;
import cl.springmachine.customer.service.customer.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerCreateRequestDTO toCustomerCreateRequestDTO(CustomerEntity entity);

    CustomerResponseDTO toCustomerResponseDTO(CustomerEntity entity);

    CustomerEntity toEntity(CustomerCreateRequestDTO request);

}
