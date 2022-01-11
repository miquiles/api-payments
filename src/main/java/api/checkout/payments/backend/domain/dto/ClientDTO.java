package api.checkout.payments.backend.domain.dto;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
public class ClientDTO {
    @NotEmpty
    @NotNull
    private String name;
    private String secondName;
    @NotNull
    private LocalDate birthDate;
    @NotEmpty
    @NotNull
    private String document;
    @NotEmpty
    @NotNull
    private String mail;
    @NotEmpty
    @NotNull
    private String password;


    private AddressDTO addressDTO;
    private CreditCardDTO creditCardDTO;

}
