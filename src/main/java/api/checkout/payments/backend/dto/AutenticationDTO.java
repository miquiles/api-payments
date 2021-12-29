package api.checkout.payments.backend.dto;

import api.checkout.payments.backend.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutenticationDTO {

    private String mail;
    private String password;
    private Boolean enable;

}
