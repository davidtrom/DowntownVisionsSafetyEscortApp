package com.zipcode.models.modelsTests;


import com.zipcode.models.Admin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@AutoConfigureTestDatabase
public class AdminModelTest {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Admin admin;

    @Before
    public void setUp(){
        id = 1L;
        firstName = "Chung";
        lastName = "Arguello";
        username = "ChungArguello";
        password = "pwd321";

        admin = new Admin(firstName, lastName, username, password);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testId(){
        //given
        Long expected = 5L;

        //when
        admin.setId(expected);
        Long actual = admin.getId();


        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFirstName(){
        //given
        String expected = "chungsing";

        //when
        admin.setFirstName(expected);
        String actual = admin.getFirstName();

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testLastName(){
        //given
        String expected = "lastNameTest";

        //when
        admin.setLastName(expected);
        String actual = admin.getLastName();

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUsername(){
        //given
        String expected = "username";

        //when
        admin.setUsername(expected);
        String actual = admin.getUsername();

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPassword(){
        //given
        String expected = "password";

        //when
        admin.setPassword(expected);
        String actual = admin.getPassword();

        //then
        Assert.assertEquals(actual, expected);
    }


}
