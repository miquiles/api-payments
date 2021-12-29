package api.checkout.payments.backend.repository;

import api.checkout.payments.backend.domain.Autentication;
import api.checkout.payments.backend.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

     Optional<Client> findByMail(String mail);

}
