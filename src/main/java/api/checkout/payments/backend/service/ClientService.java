package api.checkout.payments.backend.service;

import api.checkout.payments.backend.domain.Address;
import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.domain.dto.AddressDTO;
import api.checkout.payments.backend.domain.dto.ClientDTO;
import api.checkout.payments.backend.domain.dto.CreditCardDTO;
import api.checkout.payments.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    public Optional<Client> fetchClient(Long id) throws Exception {
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found")));
    }

    public Client builderClient(ClientDTO clientDTO){

        return  Client.builder()
                .firstName(clientDTO.getName())
                .mail(clientDTO.getMail())
                .password(clientDTO.getPassword())
                .birthDate(clientDTO.getBirthDate())
                .document(clientDTO.getDocument())
                .secondName(clientDTO.getSecondName())
                .address(builderAddress(clientDTO.getAddressDTO()))
                .creditCard(builderCreditCard(clientDTO.getCreditCardDTO()))
                .build();
    }

    public Boolean verifiUser(String mail) throws Exception{
        var clientMail = clientRepository.findByMail(mail);
        if(clientMail.isEmpty()){
            return true;
        }
        return false;
    }

    public Client save (Client client){
      return clientRepository.save(client);
    }

    public void newPassword(String mail, String password) throws Exception {
        var client = clientRepository.findEntityByMail(mail).orElseThrow(() -> new Exception("Mail not found"));
        client.setPassword(password);
    }


    public Address builderAddress(AddressDTO addressDTO) {
        return Address.builder()
                .city(addressDTO.getCity())
                .complement(addressDTO.getComplement())
                .number(addressDTO.getNumber())
                .district(addressDTO.getDistrict())
                .street(addressDTO.getStreet())
                .zipCode(addressDTO.getZipCode())
                .state(addressDTO.getState())
                .build();
    }

    public CreditCard builderCreditCard(CreditCardDTO creditCardDTO) {
        return CreditCard.builder()
                .authorizationCode(creditCardDTO.getAuthorizationCode())
                .cardBanner(creditCardDTO.getCardBanner())
                .cardNumber(creditCardDTO.getCardNumber())
                .expiredDate(creditCardDTO.getExpiredDate())
                .nameCard(creditCardDTO.getNameCard())
                .build();
    }



}

