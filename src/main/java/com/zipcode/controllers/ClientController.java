package com.zipcode.controllers;

import com.zipcode.models.Client;
import com.zipcode.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Client> addClient (@RequestBody Client client){
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<String>> displayAllClientEmails (){
        return new ResponseEntity<>(clientService.findAllEmails(),HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public  ResponseEntity<Boolean> deleteUserEmail (@RequestBody String email){
        return new ResponseEntity<>(clientService.deleteUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/check-email")
    public ResponseEntity<Boolean> checkIfEmailExists(@RequestBody String email) {
        return new ResponseEntity<>(clientService.emailAvailabilityCheck(email), HttpStatus.OK);
    }

}
