package api.checkout.payments.backend.service;

import api.checkout.payments.backend.domain.Address;
import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.dto.AddressDTO;
import api.checkout.payments.backend.dto.ClientDTO;
import api.checkout.payments.backend.dto.CreditCardDTO;
import api.checkout.payments.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Optional<Client> fetchClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client builderClient(ClientDTO clientDTO){

        return  Client.builder()
                .name(clientDTO.getName())
                .mail(clientDTO.getMail())
                .password(clientDTO.getPassword())
                .enable(clientDTO.getEnable())
                .birthDate(clientDTO.getBirthDate())
                .document(clientDTO.getDocument())
                .secondName(clientDTO.getSecondName())
                .address(builderAddress(clientDTO.getAddressDTO()))
                .creditCard(builderCreditCard(clientDTO.getCreditCardDTO()))
                .build();
    }

    public Optional<String> verifiUser(String mail){
        return clientRepository.findByMail(mail);
    }

    public Client save (Client client){
      return clientRepository.save(client);
    }

    public void newPassord(String mail, String password){
        var client = clientRepository.findEntityByMail(mail);
        if(!(client.getMail().equals(null) || client.getMail().isBlank())){
            client.setPassword(password);
        }else{
            System.out.println("Usuario inválido");
        }

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

