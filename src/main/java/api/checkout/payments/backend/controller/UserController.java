package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Autentication;
import api.checkout.payments.backend.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/user/")
public class UserController {

    @PostMapping("create-user")
    public ResponseEntity<Autentication> createNewUser(@RequestBody @Validated Autentication autentication){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(autentication, HttpStatus.CREATED);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<?> listUserTest(){
        User user = new User();
        Autentication autentication = new Autentication();
        user.setId(1L);
        user.setName("PEdro");
        user.setSecondName("Miquile de lima");
        user.setBirthDate(LocalDate.of(1993,05,29));
        autentication.setId(1L);
        autentication.setMail("miquiles87@gmail.com");
        autentication.setEnable(true);
        autentication.setPassword("123SSRE");
        user.setUserAutentication(autentication);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("ola-mundo")
    public String olaMundo(){return "ola mundo";}

}
