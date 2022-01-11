package api.checkout.payments.backend.repository;

import api.checkout.payments.backend.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

     Optional<String> findByMail(String mail);
     Optional<Client> findEntityByMail(String mail);

}
