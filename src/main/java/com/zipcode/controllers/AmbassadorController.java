package com.zipcode.controllers;


import com.zipcode.exceptions.ResourceNotFoundException;
import com.zipcode.models.Ambassador;
import com.zipcode.services.AmbassadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
public class AmbassadorController {

    @Autowired
    private AmbassadorService ambassadorService;

    @PostMapping("/ambassador/create")
    public ResponseEntity<Boolean> newAmbassador(@RequestBody Ambassador ambassador) {
        try {
            ambassadorService.newAmbassador(ambassador);
        } catch (ResourceNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<>(HttpStatus.OK);
}

    @DeleteMapping("/ambassador/delete/{id}")
    public ResponseEntity<Boolean> deleteAmbassador(@PathVariable Long id) {
        try {
            ambassadorService.deleteAmbassador(id);
        } catch (ResourceNotFoundException e)   {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/ambassador/update/{id}")
    public ResponseEntity<Boolean> updateAmbassador(@PathVariable Long id, @RequestBody Ambassador ambassador) {
        try {
            ambassadorService.updateAmbassador(id, ambassador);
        }   catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ambassador/{id}")
    public ResponseEntity<Ambassador> findById(@PathVariable Long id) {
        try {
            ambassadorService.findById(id);
        }   catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ambassadors")
    public ResponseEntity<Iterable<Ambassador>> findAll() {
        try {
            ambassadorService.findAll();
        }   catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ambassadors/name/{firstName}")
    public ResponseEntity<Ambassador> findByFirstName(@PathVariable String firstName) {
        try {
            ambassadorService.findByFirstName(firstName);
        } catch (ResourceNotFoundException e)   {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("ambassadors/last/{lastName}")
    public ResponseEntity<Ambassador> findByLastName(@PathVariable String lastName) {
        try {
            ambassadorService.findByLastName(lastName);
        }   catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
