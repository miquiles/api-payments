package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Address;
import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.dto.AddressDTO;
import api.checkout.payments.backend.dto.ClientDTO;
import api.checkout.payments.backend.dto.CreditCardDTO;
import api.checkout.payments.backend.service.ClientService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/client/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("register")
    public ResponseEntity<ClientDTO> createNewUser(@RequestBody @Validated ClientDTO clientDTO){

        var user = clientService.builderClient(clientDTO);

        if(!clientService.verifiUser(clientDTO.getMail()).isPresent()){
            clientService.save(user);
        }else{
            return new ResponseEntity<>(clientDTO, HttpStatus.NOT_ACCEPTABLE);

        }

        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @PostMapping("reset")
    public void changePassword(@RequestParam("mail") @NotNull String mail, @RequestParam("password") String password){
        clientService.newPassord(mail, password);

    }

    @GetMapping("{id}/fetch")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findClient (@PathVariable("id") Long id){

        var client = clientService.fetchClient(id);
        return client;
    }

    @PostMapping("new-client")
    public ResponseEntity<Client> create (@RequestBody @Validated Client client){
        clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

//    @GetMapping("mok")
//    public Client mok(){
//        Address address = new Address();
//        address.setCity("recife");
//        address.setZipCode("53223232");
//        address.setStreet("adolfo simoes");
//        address.setNumber("433");
//        address.setDistrict("PE");
//
//        CreditCard creditCard = new CreditCard();
//        creditCard.setCardBanner("MASTER");
//        creditCard.setCardNumber("55554444666633336666");
//        creditCard.setExpiredDate("29052023");
//        creditCard.setAuthorizationCode("999");
//        creditCard.setNameCard("Amanda alves");
//
//        return Client.builder()
//                .name("pedro henrique")
//                .secondName("Miquiles de lima")
//                .mail("miquiles@gmail.com")
//                .password("1231231231")
//                .birthDate(LocalDate.of(1993, 03, 24))
//                .enable(true)
//                .address(address)
//                .creditCard(creditCard)
//                .build();
//
//    }


//    @GetMapping("mok")
//    public Client mok (){
//        Client client = new Client();
//        client.setName("Amanda Alves");
//        client.setDocument("101582824855");
//        client.setMail("amanda@gmail.com");
//        client.setBirthDate(LocalDate.of(1993, 03, 24));
//        client.setSecondName("Alcantara");
//
//        Address address = new Address();
//        address.setCity("recife");
//        address.setZipCode("53223232");
//        address.setStreet("adolfo simoes");
//        address.setNumber("433");
//        address.setDistrict("PE");
//        client.setAddress(address);
//
//        CreditCard creditCard = new CreditCard();
//        creditCard.setCardBanner("MASTER");
//        creditCard.setCardNumber("55554444666633336666");
//        creditCard.setExpiredDate("29052023");
//        creditCard.setAuthorizationCode("999");
//        creditCard.setNameCard("Amanda alves");
//        client.setCreditCard(creditCard);
//
//        return clientService.save(client);
//
//
//    }





}
