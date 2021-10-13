package za.ac.cput.controller.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.InvoiceLine;
import za.ac.cput.factory.InvoiceLineFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceLineControllerTest
{//start of class

    //Attributes
    private static InvoiceLine invoiceLine = InvoiceLineFactory.createInvoice("9000", "46664", "fd101", "bv001", "25", "50", "R10000");
    @Autowired
    private TestRestTemplate restTemplate; // A Rest Template
    private final String BASE1_URL = "http://localhost:8080/invoiceLine/saveInvoiceLineDetails";

    @Test
    void testSaveInvoiceLineDetails()
    {
        System.out.println("URL: " + BASE1_URL);
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE1_URL, invoiceLine, Boolean.class);

        assertNotNull(postResponse);
    }

}//end of class