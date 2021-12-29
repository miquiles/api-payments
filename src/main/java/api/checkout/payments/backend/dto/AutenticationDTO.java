package api.checkout.payments.backend.dto;

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
