package za.ac.cput.service.impl;

/**
 * LoginServiceTest.java
 * Test class which test the Login Service class
 * Author: Jason Jaftha (217009301)
 * Date: 22 September 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

    //Attributes
        @Autowired
        private LoginService service = LoginService.getService();
        private Login login;

    @BeforeEach
    void setUp() {

        login = LoginFactory.createLogin("125891654", "ADMIN", "123456");
    }

    @Test
    void testLogin()
    {
        assertTrue(service.getLoginDetails("jon010snow", "Password01"));
    }

    @Test
    void testSaveRegistrationDetails()
    {
        assertTrue(service.saveRegistrationDetails(login));
    }
}