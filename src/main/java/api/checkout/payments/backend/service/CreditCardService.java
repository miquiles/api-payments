package api.checkout.payments.backend.service;

import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.domain.dto.ClientDTO;
import api.checkout.payments.backend.domain.dto.CreditCardDTO;
import api.checkout.payments.backend.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;
    ClientService clientService;
    public CreditCard create (CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    public CreditCard buildCreditCard(CreditCardDTO creditCardDTO, ClientDTO clientDTO){
        return CreditCard.builder()
                .cardBanner(creditCardDTO.getCardBanner())
                .authorizationCode(creditCardDTO.getAuthorizationCode())
                .nameCard(creditCardDTO.getNameCard())
                .expiredDate(creditCardDTO.getExpiredDate())
                .client(clientService.builderClient(clientDTO))
                .build();
    }
}
