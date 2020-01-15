package com.zipcode.services;

import com.zipcode.models.Ambassador;
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

    public Boolean newAmbassador(Ambassador ambassador){
        Ambassador newAmbassador = new Ambassador();
        newAmbassador.setFirstName(ambassador.getFirstName());
        newAmbassador.setLastName(ambassador.getLastName());
        newAmbassador.setPhoneNumber(ambassador.getPhoneNumber());
        ambassadorRepo.save(ambassador);
        return true;
    }

    public void deleteAmbassador(Long id){
          ambassadorRepo.deleteById(id);
    }

    public Boolean updateAmbassador(Long id, Ambassador ambassador){
        if(ambassadorRepo.existsById(id)){
            Ambassador updateAmbassador = findById(id);
            updateAmbassador.setFirstName(ambassador.getFirstName());
            updateAmbassador.setLastName(ambassador.getLastName());
            updateAmbassador.setPhoneNumber(ambassador.getPhoneNumber());
            ambassadorRepo.save(updateAmbassador);
            return true;
        }
        return false;
    }

    // GET methods

    public Ambassador findById(Long id){
        return ambassadorRepo.findById(id).get();
    }

    public Iterable<Ambassador> findAll(){
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

    public Boolean ambassadorExists(Long id)    {
        if(ambassadorRepo.existsById(id))   {
            return true;
        }   else {
            return  false;
        }
    }

    public Iterable<Ambassador> findAllAmbassadors()    {
        return ambassadorRepo.findAll();
    }
}
