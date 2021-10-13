package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.InvoiceLine;
import za.ac.cput.factory.InvoiceLineFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InvoiceLineServiceTest
{//start of class

    //Attributes
    @Autowired
    private InvoiceLineService service = InvoiceLineService.getService();
    private static InvoiceLine invoiceLine;

    @BeforeEach
    void setUp() {

        invoiceLine = InvoiceLineFactory.createInvoice("0020", "10" , "4547", "3", "12", "15", "R1500");
    }

    @Test
    void testSaveInvoiceLine()
    {
        assertTrue(service.saveInvoiceLineDetails(invoiceLine));
    }
}//end of class