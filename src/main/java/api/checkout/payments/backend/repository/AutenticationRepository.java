package api.checkout.payments.backend.repository;

import api.checkout.payments.backend.domain.Autentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutenticationRepository extends JpaRepository<Autentication, Long> {

     Optional<String> findByMail(String mail);
     Autentication findEntityByMail(String mail);
}
