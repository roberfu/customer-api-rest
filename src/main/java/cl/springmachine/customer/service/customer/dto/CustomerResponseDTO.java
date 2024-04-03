package cl.springmachine.customer.service.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CustomerResponseDTO {

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

    @JsonProperty("invoice_data_id")
    private Integer invoiceDataId;

    @JsonProperty("customer_type")
    private String customerType;

    @JsonProperty("legal_name")
    private String legalName;

    private String classification;

}
