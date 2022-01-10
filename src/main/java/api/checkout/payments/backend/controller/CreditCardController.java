package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.dto.ClientDTO;
import api.checkout.payments.backend.domain.dto.CreditCardDTO;
import api.checkout.payments.backend.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards/")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("create-card")
    public ResponseEntity<CreditCardDTO> newCard (CreditCardDTO creditCardDTO, ClientDTO clientDTO){
        creditCardService.create(creditCardService.buildCreditCard(creditCardDTO, clientDTO));
        return new ResponseEntity<>(creditCardDTO, HttpStatus.CREATED);
    }

}
