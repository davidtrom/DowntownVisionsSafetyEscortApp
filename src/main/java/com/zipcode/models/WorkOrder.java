package com.zipcode.models;


import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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
    private LocalDate dateCreated;
    //optional image upload
    @NotNull
    private WorkOrderStatus workOrderStatus;
    private LocalDate dateCompleted;
    @OneToMany
    private List<Ambassador> ambassadorList;




    public WorkOrder() {
    }

    public WorkOrder(String firstName, String lastName, String description, String location, LocalDate date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.location = location;
        this.dateCreated = LocalDate.now();
        this.workOrderStatus = WorkOrderStatus.OPEN;
        this.dateCompleted = null;
    }



    public WorkOrder(Long id, String firstName, String lastName, String description, String location, LocalDate date) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.location = location;
        this.dateCreated = LocalDate.now();
        this.dateCompleted = null;
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

    public List<Ambassador> getAmbassadorList() {
        return ambassadorList;
    }

    public void setAmbassadorList(List<Ambassador> ambassadorList) {
        this.ambassadorList = ambassadorList;
    }

    public void assignAmbassador(Ambassador ambassador)    {
        ambassadorList.add(ambassador);
    }

    public void removeAmbassador(Ambassador ambassador) {
        ambassadorList.remove(ambassador);
    }
}
