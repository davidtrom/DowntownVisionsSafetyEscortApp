package com.zipcode.models;


import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String description;
    @NotNull
    private String location;
    private LocalDate dateCreated = LocalDate.now();
    //optional image upload
    private WorkOrderStatus workOrderStatus = WorkOrderStatus.OPEN;
    private LocalDate dateCompleted = null;




    public WorkOrder() {
    }

    public WorkOrder(String firstName, String lastName, String description, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.location = location;
    }



    public WorkOrder(Long id, String firstName, String lastName, String description, String location) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.location = location;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String message) {
        this.description = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate date) {
        this.dateCreated = date;
    }

    public WorkOrderStatus getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(WorkOrderStatus status) {
        this.workOrderStatus = status;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
