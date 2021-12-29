package api.checkout.payments.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String complement;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private String state;
    private String district;

    @OneToOne
    private Client client;

}
