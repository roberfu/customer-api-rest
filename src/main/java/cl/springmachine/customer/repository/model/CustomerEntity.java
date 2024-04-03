package cl.springmachine.customer.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String documentType;

    private String documentId;

    private String phone;

    private String email;

    private Integer addressId;

    private Integer invoiceDataId;

    private String customerType;

    private String legalName;

    private String classification;

}
