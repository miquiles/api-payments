package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.domain.CreditCard;
import api.checkout.payments.backend.domain.dto.AddressDTO;
import api.checkout.payments.backend.domain.dto.ClientDTO;
import api.checkout.payments.backend.domain.dto.CreditCardDTO;
import api.checkout.payments.backend.service.ClientService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping("/clients/")
public class ClientController {

    ClientService clientService;

    @GetMapping("heroku")
    public String herokuTest(){return "we are oline";}

   @PostMapping("register")
    public ResponseEntity<ClientDTO> createNewUser(@RequestBody @Validated ClientDTO clientDTO){
        var user = clientService.builderClient(clientDTO);
        try {
            if (clientService.verifyUser(user.getMail()) == true) {
                clientService.save(user);
                return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("reset")
    public void changePassword(@RequestParam("mail") @NotNull String mail, @RequestParam("password") String password) throws Exception {
        clientService.newPassword(mail, password);
    }

    @GetMapping("fetch-client/")
    public ResponseEntity<?> findClient (@RequestParam String mail) throws Exception {

        try{
            var client = clientService.fetchClientByEmail(mail);
            return ResponseEntity.ok(client.get());}
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }



}
