package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.domain.dto.AddressDTO;
import api.checkout.payments.backend.domain.dto.ClientDTO;
import api.checkout.payments.backend.domain.dto.CreditCardDTO;
import api.checkout.payments.backend.service.ClientService;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/mock")
    public ClientDTO mock (){
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCity("recife");
        addressDTO.setDistrict("Pe");
        addressDTO.setStreet("jurema");
        addressDTO.setZipCode("121212");

        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardDTO.setCardBanner("ëlo");
        creditCardDTO.setCardNumber("22");
        creditCardDTO.setAuthorizationCode("444");
        creditCardDTO.setExpiredDate("29/05/2022");

        return ClientDTO.builder()
                .name("name")
                .birthDate(LocalDate.of(1993, 05, 29))
                .mail("miquies@gmail.com")
                .document("123")
                .enable(true)
                .secondName("miquiles")
                .addressDTO(addressDTO)
                .creditCardDTO(creditCardDTO)
                .build();
    }

    @PostMapping("register")
    public ResponseEntity<ClientDTO> createNewUser(@RequestBody @Validated ClientDTO clientDTO){
        var user = clientService.builderClient(clientDTO);
        try {
            if (clientService.verifiUser(user.getMail()) == true) {
                clientService.save(user);
                return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(clientDTO, HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("reset")
    public void changePassword(@RequestParam("mail") @NotNull String mail, @RequestParam("password") String password){
        clientService.newPassord(mail, password);

    }

    @GetMapping("{id}/fetch")
    public ResponseEntity<?> findClient (@PathVariable("id") Long id){
        var client = clientService.fetchClient(id);
        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("new-client")
    public ResponseEntity<Client> create (@RequestBody @Validated Client client){
        clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }




}
