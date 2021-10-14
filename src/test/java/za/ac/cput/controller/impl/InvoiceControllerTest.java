package za.ac.cput.controller.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Invoice;
import za.ac.cput.factory.InvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;

@Deprecated
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceControllerTest
{//start of class

    //Attributes
    private static Invoice invoice = InvoiceFactory.createInvoice("9", "date", "217091229", "ev007", "R90059");
    @Autowired
    private TestRestTemplate restTemplate; // A Rest Template
    private final String BASE1_URL = "http://localhost:8080/invoice/getInvoice";
    private final String BASE2_URL = "http://localhost:8080/invoice/saveInvoice";

    @Test
    void testGetInvoice()
        {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(BASE1_URL, HttpMethod.GET, entity, String.class);

            System.out.println("Show Invoice: ");
            System.out.println(response.getBody());
        }

    @Test
    void testSaveInvoiceDetails()
    {
        System.out.println("URL: " + BASE2_URL);
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE2_URL, invoice, Boolean.class);

        assertNotNull(postResponse);
    }

}//end of class