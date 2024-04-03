package cl.springmachine.customer.service.customer.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CustomerFindRequestDTO {

    private String firstName;

    private String lastName;

    private String documentId;

    private String email;

}
