package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.InvoiceLine;
import za.ac.cput.service.impl.InvoiceLineService;

/**
 * InvoiceLineController.java
 * Controller for the InvoiceLine Service
 * Author: Siyanda Hlongwa (217091229)
 * Date: 4 October 2021
 **/

@RestController
@RequestMapping("/invoiceLine")
public class InvoiceLineController
{//start of class

    //Attributes
    @Autowired
    private InvoiceLineService invoiceLineService;

    //saveInvoice
    @PostMapping("/saveInvoiceLineDetails")
    public boolean saveInvoiceLineDetails(@RequestBody InvoiceLine invoiceLine)
    {
        return this.invoiceLineService.saveInvoiceLineDetails(invoiceLine);
    }

}//end of class
