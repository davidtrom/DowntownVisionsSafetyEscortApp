package com.zipcode.models.modelsTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import com.zipcode.models.Ambassador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

class AmbassadorTest {
    Ambassador testAmbassador;

    @BeforeEach
    void setUp() {
        testAmbassador = new Ambassador("FirstName", "LastName", "302-123-4567");
    }

    @Test
    public void testClassSignatureAnnotations() {
        Assertions.assertTrue(Ambassador.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Ambassador ta1 = new Ambassador();
        String json = jsonWriter.writeValueAsString(ta1);
    }

    @Test
    void getFirstName(){
        String expected = "FirstName";
        String actual = testAmbassador.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName(){
        String expected = "LastName";
        String actual = testAmbassador.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPhoneNumber(){
        String expected = "302-123-4567";
        String actual = testAmbassador.getPhoneNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setFirstName() {
        String expected = "NewFirstName";
        testAmbassador.setFirstName(expected);
        String actual = testAmbassador.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setLastName() {
        String expected = "NewLastName";
        testAmbassador.setLastName(expected);
        String actual = testAmbassador.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setPhoneNumber() {
        String expected = "215-302-8891";
        testAmbassador.setPhoneNumber(expected);
        String actual = testAmbassador.getPhoneNumber();
        Assertions.assertEquals(expected, actual);
    }
}
