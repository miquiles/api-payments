package api.checkout.payments.backend.service;

import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.dto.ClientDTO;
import api.checkout.payments.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Optional<Client> fetchClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client save (Client client){
        return clientRepository.save(client);
    }
}

