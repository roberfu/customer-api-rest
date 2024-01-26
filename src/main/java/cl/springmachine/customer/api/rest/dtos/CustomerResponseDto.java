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

    // private Address address;

    // private InvoiceData invoiceData;

    @JsonProperty("customer_type")
    private String customerType;

    @JsonProperty("legal_name")
    private String legalName;

    // private Contact contact;

    private String classification;

}
