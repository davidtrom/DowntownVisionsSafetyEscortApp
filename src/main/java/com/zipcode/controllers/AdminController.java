package com.zipcode.controllers;


import com.zipcode.models.Admin;
import com.zipcode.models.dtoModels.AdminRegisterDTO;
import com.zipcode.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.zipcode.services")
public class AdminController {


    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //----------------------------------create----------------------------------

    @PostMapping("/admin/create")
    public ResponseEntity<Admin> newAdmin(@RequestBody AdminRegisterDTO admin){
        return new ResponseEntity<>(adminService.newAdmin(admin), HttpStatus.CREATED);
    }

    //----------------------------------get methods----------------------------------


//    @PutMapping("/admin/update/{id}")
//    public ResponseEntity<Boolean> updateAdminLastName(@PathVariable Long id, @RequestBody String lastName){
//        Admin admin = adminService.findById(id);
//        if(admin == null)   {
//            throw new AdminNotFoundException();
//        }
//        adminService.updateAdmin(admin, lastName);
//        return new ResponseEntity<>(adminService.updateAdmin(id, admin), HttpStatus.OK);
//    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable Long id){
        return new ResponseEntity<>(adminService.deleteAdmin(id), HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> findById(@PathVariable Long id){
        return new ResponseEntity<>(adminService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/admins")
    public ResponseEntity<Iterable<Admin>> findAll(){
        return new ResponseEntity<>(adminService.findAll(), HttpStatus.OK);
    }


}
