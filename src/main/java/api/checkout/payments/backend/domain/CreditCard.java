package api.checkout.payments.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorizationCode;
    private String cardNumber;
    private String expiredDate;
    private String nameCard;
    private String cardBanner;

    @OneToOne
    private Client client;
}
