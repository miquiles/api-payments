package api.checkout.payments.backend.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Autentication {

    private Long id;
    private String mail;
    private String password;
    private Boolean enable;

}
