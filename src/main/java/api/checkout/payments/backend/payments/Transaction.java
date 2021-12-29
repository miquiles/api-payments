package api.checkout.payments.backend.payments;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime transactionDate;
    private Integer amount;
    private String authorizationCode;
    private Integer installments;
    private String cardBanner;
    private String cardNumber;
    private String nameCard;
    private Integer status;
    private Integer installmentAmount;
    private UUID paymentId;


}
