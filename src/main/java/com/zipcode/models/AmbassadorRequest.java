package com.zipcode.models;
import com.zipcode.models.WorkOrderAndRequestStatus.AmbassadorRequestStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class AmbassadorRequest {

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

//    @OneToOne
//    private Ambassador ambassador;

    private LocalDate date = LocalDate.now();
    private AmbassadorRequestStatus ambassadorRequestStatus = AmbassadorRequestStatus.OPEN;


    public AmbassadorRequest() {
    }

    public AmbassadorRequest(String firstName, String lastName, String phoneNumber, String pickUpLocation, String dropOffLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        //this.email = email;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public AmbassadorRequest(Long id, String firstName, String lastName, String phoneNumber, String pickUpLocation, String dropOffLocation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public AmbassadorRequestStatus getAmbassadorRequestStatus() {
        return ambassadorRequestStatus;
    }

    public void setAmbassadorRequestStatus(AmbassadorRequestStatus ambassadorRequestStatus) {
        this.ambassadorRequestStatus = ambassadorRequestStatus;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

//    public String getEmail() { return email; }
//
//    public void setEmail(String email) { this.email = email; }

    public String getPickUpLocation() { return pickUpLocation; }

    public void setPickUpLocation(String pickUpLocation) { this.pickUpLocation = pickUpLocation; }

    public String getDropOffLocation() { return dropOffLocation; }

    public void setDropOffLocation(String dropOffLocation) { this.dropOffLocation = dropOffLocation; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

//    public Ambassador getAmbassador() { return ambassador; }
//
//    public void setAmbassador(Ambassador ambassador) { this.ambassador = ambassador; }

    // Maybe added later - design decision
//    public List<Ambassador> getAmbassadorList() {
//        return ambassadorList;
//    }
//
//    public void setAmbassadorList(List<Ambassador> ambassadorList) {
//        this.ambassadorList = ambassadorList;
//    }
}
