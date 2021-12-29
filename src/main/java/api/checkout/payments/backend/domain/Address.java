package api.checkout.payments.backend.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Address {
    private Long id;
    private String complement;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private String state;
    private String district;
}
