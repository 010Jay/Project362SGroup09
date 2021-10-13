package za.ac.cput.controller.impl;

/**
 * LoginControllerTest.java
 * Test class for the Login controller
 * Author: Jason Jaftha (217009301)
 * Date: 4 October 2021
 **/

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    //Attributes
        private static Login login = LoginFactory.createLogin("216852456", "user", "user123");
        @Autowired
        private TestRestTemplate restTemplate;
    private final String BASE_URL1 = "http://localhost:8080/login/getLoginDetails";
    private final String BASE_URL2 = "http://localhost:8080/login/saveRegistrationDetails";

    //@Disabled("This test is not fully implemented yet!")
    @Test
    void testGetLoginDetails()
    {//Url for the create method
        System.out.println("URL: " + BASE_URL1);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder queryParams = UriComponentsBuilder.fromHttpUrl(BASE_URL1)
        .queryParam("username", "jon010snow")
        .queryParam("password", "Password01");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Boolean> response = restTemplate.exchange(queryParams.build().toUriString(), HttpMethod.POST, entity, boolean.class);

        assertTrue(response.getBody());
    }

    @Test
    void testSaveRegistrationDetails()
    {
        System.out.println("URL: " + BASE_URL2);
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE_URL2, login, Boolean.class);

        assertNotNull(postResponse);
    }
}