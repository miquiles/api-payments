package api.checkout.payments.backend.payments;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transactions {
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
