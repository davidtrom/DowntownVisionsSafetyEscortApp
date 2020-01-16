package com.zipcode.services;

import com.zipcode.models.Client;
import com.zipcode.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public Client addClient (Client client) {
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setEmail(client.getEmail());
        return clientRepo.save(client);
    }

    public Iterable<String> findAllEmails() {
        ArrayList<String> userEmails = new ArrayList<>();
        Iterable<Client> allClients = clientRepo.findAll();
        for (Client client : allClients){
            userEmails.add(client.getEmail());
        }
        return userEmails;
    }

    public Boolean emailAvailabilityCheck(String email) {
        Iterable <String> allUserEmails = findAllEmails();
        for(String userEmail : allUserEmails){
            if(email.equals(userEmail)){
                return false;
            }
        }
        return true;
    }

    public Boolean deleteUserByEmail (String email){
        return clientRepo.deleteByEmail(email);
    }
}
