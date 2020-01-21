package com.zipcode.models.controllerTests;

import com.zipcode.controllers.AdminController;
import com.zipcode.services.AdminService;
import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTests {

    private MockMvc mockMvc;

    @InjectMocks
    private AdminService adminService;

    @InjectMocks
    private  AdminController adminController;

    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(adminController)
                .addFilters(new CorsFilter())
                .build();
    }





}
