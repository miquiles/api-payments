package api.checkout.payments.backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private LocalDate birthDate;
    private String document;
    @OneToOne
    private Autentication userAutentication;
    @OneToMany
    private Address userAddress;
    @OneToMany
    private CreditCard creditCard;

}
