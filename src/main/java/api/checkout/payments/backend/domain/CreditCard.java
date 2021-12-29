package api.checkout.payments.backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorizationCode;
    private String cardNumber;
    private String expiredDate;
    private String nameCard;
    private String cardBanner;
}
