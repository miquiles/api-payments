package api.checkout.payments.backend.controller;

import api.checkout.payments.backend.domain.Client;
import api.checkout.payments.backend.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/client/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("{id}/fetch")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findClient (@PathVariable("id") Long id){

        var client = clientService.fetchClient(id);
        return client;
    }

    @PostMapping("new-client")
    public ResponseEntity<Client> save (@RequestBody @Validated Client client){
        clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }





}
