package api.checkout.payments.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String secondName;
    @Column(nullable = false)
    private LocalDate birthDate;
    private String document;
    @Column(unique = true, nullable = false)
    private String mail;
    private String password;
    private Boolean enable;


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

}
