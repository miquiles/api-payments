package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Autentication;
import api.checkout.payments.backend.dto.AutenticationDTO;
import api.checkout.payments.backend.service.AutenticationService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autentication/")
public class AutenticationController {

    @Autowired
    AutenticationService autenticationService;

    @PostMapping("register")
    public ResponseEntity<Autentication> createNewUser(@RequestBody @Validated AutenticationDTO autenticationDTO){

        var user = autenticationService.toAutentication(autenticationDTO);

        if(!autenticationService.verifyIfExists(user.getMail()).isPresent()){
            autenticationService.save(user);
        }else{
            return new ResponseEntity<>(user, HttpStatus.NOT_ACCEPTABLE);

        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("reset")
    public void changePassword(@RequestParam("mail") @NotNull String mail, @RequestParam("password") String password){
        autenticationService.newPassord(mail, password);

    }
}
