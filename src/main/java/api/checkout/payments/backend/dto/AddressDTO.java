package api.checkout.payments.backend.dto;

import api.checkout.payments.backend.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
@Builder
public class AddressDTO {
    private String complement;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private String state;
    private String district;

}
