package com.zipcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class AmbassadorRequest {
    //AmbassadorRequest Fields
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phoneNumber;
//    @NotNull
//    private String email;

    //The city, state, and zip will all be in Wilmington.  We need a way to double check people are in the designated zone.

    @NotNull
    private String pickUpLocation;
    @NotNull
    private String dropOffLocation;

    private LocalDate date = LocalDate.now();
//    @OneToMany
//    private List<Ambassador> ambassadorList;

    private Long ambassadorId;



    public AmbassadorRequest() {
    }

//    public AmbassadorRequest(String firstName, String lastName, String phoneNumber, String email, String pickUpLocation, String dropOffLocation) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.pickUpLocation = pickUpLocation;
//        this.dropOffLocation = dropOffLocation;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//    }

    public AmbassadorRequest(@NotNull String firstName, @NotNull String lastName, @NotNull String phoneNumber, @NotNull String pickUpLocation, @NotNull String dropOffLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public LocalDate getDate() {
        return date;
    }

    public Long getAmbassadorId() {
        return ambassadorId;
    }

    public void setAmbassadorId(Long ambassadorId) {
        this.ambassadorId = ambassadorId;
    }

    // May be added later - design decision
//    public List<Ambassador> getAmbassadorList() {
//        return ambassadorList;
//    }
//
//    public void setAmbassadorList(List<Ambassador> ambassadorList) {
//        this.ambassadorList = ambassadorList;
//    }
}
