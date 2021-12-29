package api.checkout.payments.backend.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserDTO {

    private String name;
    private String secondName;
    private LocalDate birthDate;
    private String document;

}
