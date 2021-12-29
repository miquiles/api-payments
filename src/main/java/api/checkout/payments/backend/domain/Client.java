package api.checkout.payments.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secondName;
    private LocalDate birthDate;
    private String document;
    private String mail;

    @OneToOne
    private Autentication userAutentication;

    @OneToOne
    private Address address;

    @OneToOne
    private CreditCard creditCard;

}
