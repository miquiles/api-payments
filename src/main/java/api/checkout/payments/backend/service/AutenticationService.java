package api.checkout.payments.backend.service;

import api.checkout.payments.backend.domain.Autentication;
import api.checkout.payments.backend.dto.AutenticationDTO;
import api.checkout.payments.backend.repository.AutenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService {

    @Autowired
    AutenticationRepository autenticationRepository;

    public Optional<String> verifyIfExists(String mail){
         var user =  autenticationRepository.findByMail(mail);
         return user;
    }

    public Autentication save(Autentication autentication){
        return autenticationRepository.save(autentication);
    }

    public void newPassord(String mail, String password){
        if(verifyIfExists(mail).isPresent()){
            var user = autenticationRepository.findEntityByMail(mail);
            user.setPassword(password);
            autenticationRepository.save(user);


        }

    }

    public Autentication toAutentication(AutenticationDTO autenticationDTO){
        return Autentication.builder()
                .enable(autenticationDTO.getEnable())
                .mail(autenticationDTO.getMail())
                .password(autenticationDTO.getPassword())
                .build();
    }




}
