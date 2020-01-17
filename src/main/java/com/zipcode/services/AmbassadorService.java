package com.zipcode.services;

import com.zipcode.models.Ambassador;
import com.zipcode.models.WorkOrder;
import com.zipcode.repositories.AmbassadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan("com.zipcode.repositories")
@Service
public class AmbassadorService {


    private AmbassadorRepo ambassadorRepo;

    @Autowired
    public AmbassadorService(AmbassadorRepo ambassadorRepo) {
        this.ambassadorRepo = ambassadorRepo;
    }

    public Boolean createAmbassador(Ambassador ambassador) {
        Ambassador newAmbassador = new Ambassador();
        newAmbassador.setFirstName(ambassador.getFirstName());
        newAmbassador.setLastName(ambassador.getLastName());
        newAmbassador.setPhoneNumber(ambassador.getPhoneNumber());
        ambassadorRepo.save(ambassador);
        return true;
    }

    public void deleteAmbassador(Long id) {
        ambassadorRepo.deleteById(id);
    }


    public void updateAmbassador(Ambassador ambassador) {
        ambassador.setFirstName(ambassador.getFirstName());
        ambassador.setLastName(ambassador.getLastName());
        ambassador.setPhoneNumber(ambassador.getPhoneNumber());
        ambassadorRepo.save(ambassador);
    }

    // GET methods

    public Ambassador findById(Long id) {
        return ambassadorRepo.findById(id).get();
    }

    public Iterable<Ambassador> findAll() {
        return ambassadorRepo.findAll();
    }

    public Iterable<Ambassador> findAllAmbassadorsByFirstName(String firstName) {
        Iterable<Ambassador> ambassadors = ambassadorRepo.findAmbassadorsByFirstName(firstName);
        if (ambassadors == null) {
            return null;
        } else {
            return ambassadors;
        }
    }

    public Iterable<Ambassador> findAllAmbassadorsByLastName(String lastName) {
        Iterable<Ambassador> ambassadors = ambassadorRepo.findAmbassadorsByLastName(lastName);
        if (ambassadors == null) {
            return null;
        } else {
            return ambassadors;
        }
    }

    public Iterable<Ambassador> findAllAmbassadors() {
        return ambassadorRepo.findAll();
    }


    public Boolean ambassadorExists(Long id) {
        if (ambassadorRepo.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Ambassador> findAmbassadorsByWorkOrder(WorkOrder workOrder) {
       Iterable<Ambassador> ambassadors = ambassadorRepo.findAmbassadorsByWorkOrder(workOrder);
       if(ambassadors == null)  {
           return null;
       }    else {
           return ambassadors;
       }
    }



}


