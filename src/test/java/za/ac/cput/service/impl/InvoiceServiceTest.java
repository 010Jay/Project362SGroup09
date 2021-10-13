package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Invoice;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.factory.LoginFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceServiceTest
{//start of class

    //Attributes
    @Autowired
    private InvoiceService service = InvoiceService.getService();
    private static Invoice invoice;

    @BeforeEach
    void setUp() {

        invoice = InvoiceFactory.createInvoice("0010", "10/10/2021", "217091229", "65412", "R1000");
    }

    @Test
    void testGetInvoiceList()
    {
        Set<Invoice> invoiceList = service.getInvoice();

        for(Invoice i:invoiceList)
        {
            System.out.println(i.toString());
        }
    }

    @Test
    void testSaveInvoiceList()
    {
        assertTrue(service.saveInvoice(invoice));
    }
}//end of class