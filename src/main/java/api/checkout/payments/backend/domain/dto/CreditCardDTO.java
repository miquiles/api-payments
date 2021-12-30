package api.checkout.payments.backend.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditCardDTO {


    private Long id;
    private String authorizationCode;
    private String cardNumber;
    private String expiredDate;
    private String nameCard;
    private String cardBanner;


}
