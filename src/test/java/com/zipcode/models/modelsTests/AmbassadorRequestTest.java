package com.zipcode.models.modelsTests;

import com.zipcode.models.AmbassadorRequest;
import com.zipcode.models.WorkOrderAndRequestStatus.AmbassadorRequestStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AmbassadorRequestTest {
    private AmbassadorRequest ambassadorRequest;

    @BeforeEach
    void setUp() {
        ambassadorRequest = new AmbassadorRequest(12L, "FirstName", "LastName", "302-123-4567", "1007 N. Orange St.", "Stitch House Brewery");
    }

    @Test
    void getId() {
        Long expected = 12L;
        Assertions.assertEquals(expected, ambassadorRequest.getId());
    }

    @Test
    void setId() {
        Long expected = 42L;
        ambassadorRequest.setId(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getId());
    }

    @Test
    void getFirstName() {
        String expected = "FirstName";
        Assertions.assertEquals(expected, ambassadorRequest.getFirstName());
    }

    @Test
    void setFirstName() {
        String expected = "NewFirstName";
        ambassadorRequest.setFirstName(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getFirstName());
    }

    @Test
    void getLastName() {
        String expected = "LastName";
        Assertions.assertEquals(expected, ambassadorRequest.getLastName());
    }

    @Test
    void setLastName() {
        String expected = "NewLastName";
        ambassadorRequest.setLastName(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getLastName());
    }

    @Test
    void getPhoneNumber() {
        String expected = "302-123-4567";
        Assertions.assertEquals(expected, ambassadorRequest.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        String expected = "302-555-1982";
        ambassadorRequest.setPhoneNumber(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getPhoneNumber());
    }

    @Test
    void getPickUpLocation() {
        String expected = "1007 N. Orange St.";
        Assertions.assertEquals(expected, ambassadorRequest.getPickUpLocation());
    }

    @Test
    void setPickUpLocation() {
        String expected = "M&T Bank Building";
        ambassadorRequest.setPickUpLocation(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getPickUpLocation());
    }

    @Test
    void getDropOffLocation() {
        String expected = "Stitch House Brewery";
        Assertions.assertEquals(expected, ambassadorRequest.getDropOffLocation());
    }

    @Test
    void setDropOffLocation() {
        String expected = "DiMeo's Pizza";
        ambassadorRequest.setDropOffLocation(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getDropOffLocation());
    }

    @Test
    void getDate() {
        LocalDate expected = LocalDate.now();
        Assertions.assertEquals(expected, ambassadorRequest.getDate());
    }

    @Test
    void setDate() {
        LocalDate expected = LocalDate.ofEpochDay(2020-01-31);
        ambassadorRequest.setDate(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getDate());
    }

    @Test
    void getAmbassadorRequestStatus() {
        AmbassadorRequestStatus expected = AmbassadorRequestStatus.OPEN;
        Assertions.assertEquals(expected, ambassadorRequest.getAmbassadorRequestStatus());
    }

    @Test
    void setAmbassadorRequestStatus() {
        AmbassadorRequestStatus expected = AmbassadorRequestStatus.CLOSED;
        ambassadorRequest.setAmbassadorRequestStatus(expected);
        Assertions.assertEquals(expected, ambassadorRequest.getAmbassadorRequestStatus());
    }
}