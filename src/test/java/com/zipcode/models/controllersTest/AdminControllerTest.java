package com.zipcode.models.controllersTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.controllers.AdminController;
import com.zipcode.models.Admin;
import com.zipcode.repositories.AdminRepo;
import com.zipcode.services.AdminService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AdminService adminService;

    @InjectMocks
    AdminController adminController;

    @MockBean
    AdminRepo adminRepo;

    Admin adminTest;

    @Before
    public void setUp(){
        adminTest = new Admin("chung", "arguello",
                "chungarguello", "password");
        adminTest.setId(1L);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/admin/create")
                .content(asJsonString(new Admin("chung", "arguello",
                        "chungarguello", "password")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        verify(adminService, times(1)).newAdmin(any(Admin.class));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
