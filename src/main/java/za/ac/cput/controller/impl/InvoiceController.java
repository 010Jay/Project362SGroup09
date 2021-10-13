package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Invoice;
import za.ac.cput.service.impl.InvoiceService;

import java.util.Set;

/**
 * InvoiceController.java
 * Controller for the Invoice Service
 * Author: Siyanda Hlongwa (217091229)
 * Date: 4 October 2021
 **/

@RestController
@RequestMapping("/invoice")
public class InvoiceController
{//start of class

    //getInvoice
    //Attributes
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/getInvoice")
    public Set<Invoice> getInvoice()
    {
        return this.invoiceService.getInvoice();
    }

    //saveInvoice
    @PostMapping("/saveInvoice")
    public boolean saveInvoice(@RequestBody Invoice invoice)
    {
        return this.invoiceService.saveInvoice(invoice);
    }
}//end of class
