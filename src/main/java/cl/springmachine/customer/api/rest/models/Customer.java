package cl.springmachine.customer.api.rest.models;

import org.springframework.data.annotation.Id;

public record Customer(@Id Integer id, String firstName, String lastName) {
}
