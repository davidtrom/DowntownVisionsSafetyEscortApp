package com.zipcode.models.modelsTests;

import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WorkOrderTest {

    private WorkOrder testWorkOrder;

    @BeforeEach
    void setUp() {
        testWorkOrder = new WorkOrder(82L, "FirstName", "LastName", "Graffiti on side of building", "1007 N. Orange St.");
    }

    @Test
    void getId() {
        Long expected = 82L;
        Assertions.assertEquals(expected, testWorkOrder.getId());
    }

    @Test
    void setId() {
        Long expected = 87L;
        testWorkOrder.setId(expected);
        Assertions.assertEquals(expected, testWorkOrder.getId());
    }

    @Test
    void getFirstName() {
        String expected = "FirstName";
        Assertions.assertEquals(expected, testWorkOrder.getFirstName());
    }

    @Test
    void setFirstName() {
        String expected = "NewFirstName";
        testWorkOrder.setFirstName(expected);
        Assertions.assertEquals(expected, testWorkOrder.getFirstName());
    }

    @Test
    void getLastName() {
        String expected = "LastName";
        Assertions.assertEquals(expected, testWorkOrder.getLastName());
    }

    @Test
    void setLastName() {
        String expected = "NewLastName";
        testWorkOrder.setLastName(expected);
        Assertions.assertEquals(expected, testWorkOrder.getLastName());
    }

    @Test
    void getDescription() {
        String expected = "Graffiti on side of building";
        Assertions.assertEquals(expected, testWorkOrder.getDescription());
    }

    @Test
    void setDescription() {
        String expected = "Dog turds on sidewalk";
        testWorkOrder.setDescription(expected);
        Assertions.assertEquals(expected, testWorkOrder.getDescription());
    }

    @Test
    void getLocation() {
        String expected = "1007 N. Orange St.";
        Assertions.assertEquals(expected, testWorkOrder.getLocation());
    }

    @Test
    void setLocation() {
        String expected = "8080 S. Orange St.";
        testWorkOrder.setLocation(expected);
        Assertions.assertEquals(expected, testWorkOrder.getLocation());
    }

    @Test
    void getDateCreated() {
        //LocalDate expected = LocalDate.ofEpochDay(2020-01-18);
        LocalDate expected = LocalDate.now();
        Assertions.assertEquals(expected, testWorkOrder.getDateCreated());
    }

    @Test
    void setDateCreated() {
        LocalDate expected = LocalDate.ofEpochDay(2019-12-18);
        testWorkOrder.setDateCreated(expected);
        Assertions.assertEquals(expected, testWorkOrder.getDateCreated());
    }

    @Test
    void getWorkOrderStatus() {
        Assertions.assertEquals(WorkOrderStatus.OPEN, testWorkOrder.getWorkOrderStatus());
    }

    @Test
    void setWorkOrderStatus() {
        testWorkOrder.setWorkOrderStatus(WorkOrderStatus.CLOSED);
        Assertions.assertEquals(WorkOrderStatus.CLOSED, testWorkOrder.getWorkOrderStatus());
    }

    @Test
    void getDateCompleted() {
        LocalDate expected = null;
        Assertions.assertEquals(expected, testWorkOrder.getDateCompleted());
    }

    @Test
    void setDateCompleted() {
        LocalDate expected = LocalDate.ofEpochDay(2020-01-31);
        testWorkOrder.setDateCompleted(expected);
        Assertions.assertEquals(expected, testWorkOrder.getDateCompleted());
    }
}