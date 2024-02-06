package cl.springmachine.customer.api.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDto {

	private String id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("document_type")
	private String documentType;

	@JsonProperty("document_id")
	private String documentId;

	private String phone;

	private String email;

	@JsonProperty("address_id")
	private Integer addressId;

	@JsonProperty("ivoice_data_id")
	private Integer invoiceDataId;

	@JsonProperty("customer_type")
	private String customerType;

	@JsonProperty("legal_name")
	private String legalName;

	private String classification;

}
