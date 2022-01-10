package api.checkout.payments.backend.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardDTO {


    private Long id;
    private String authorizationCode;
    private String cardNumber;
    private String expiredDate;
    private String nameCard;
    private String cardBanner;


}
