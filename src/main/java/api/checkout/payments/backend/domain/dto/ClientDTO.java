package api.checkout.payments.backend.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClientDTO {

    private String name;
    private String secondName;
    private LocalDate birthDate;
    private String document;
    private String mail;
    private String password;
    private Boolean enable;

    private AddressDTO addressDTO;
    private CreditCardDTO creditCardDTO;

}
