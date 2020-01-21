package com.zipcode.models.modelsTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

public class ClientTest {

    private Client testClient;

    @BeforeEach
    void setUp() {
        testClient = new Client("FirstName", "LastName","myemail@gmail.com", "www.personalwebsite.com", "www.abusinesswebsite.com");
    }

    @Test
    public void testClassSignatureAnnotations() {
        Assertions.assertTrue(Client.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Client client = new Client();
        String json = jsonWriter.writeValueAsString(client);
    }

    @Test
    void getFirstName() {
        String expected = "FirstName";
        String actual = testClient.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = "LastName";
        String actual = testClient.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "myemail@gmail.com";
        String actual = testClient.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getWebsite () {
        String expected = "www.personalwebsite.com";
        String actual = testClient.getWebsite();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getBusinessWebsite () {
        String expected = "www.abusinesswebsite.com";
        String actual = testClient.getBusinessWebsite();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setFirstName() {
        String expected = "NewFirstName";
        testClient.setFirstName(expected);
        String actual = testClient.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setLastName() {
        String expected = "NewLastName";
        testClient.setLastName(expected);
        String actual = testClient.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setEmail() {
        String expected = "myNewEmail@gmail.com";
        testClient.setEmail(expected);
        String actual = testClient.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setEmail2() {
        //email won't get changed because it's invalid
        String expected = "myNewEmail@";
        testClient.setEmail(expected);
        String actual = testClient.getEmail();
        Assertions.assertEquals("myemail@gmail.com", actual);
    }

    @Test
    void setPersonalWebsite() {
        String expected = "www.thisismynewwebsite.com";
        testClient.setWebsite(expected);
        String actual = testClient.getWebsite();
        Assertions.assertEquals("www.thisismynewwebsite.com", actual);
    }

    @Test
    void setBusinessWebsite() {
        String expected = "www.thisismynewbusinesswebsite.com";
        testClient.setBusinessWebsite(expected);
        String actual = testClient.getBusinessWebsite();
        Assertions.assertEquals("www.thisismynewbusinesswebsite.com", actual);
    }

}
