package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.generic.GenericHelper;
import za.ac.cput.generic.GenericSession;
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

    private String studentNumber, eventCode;
    private String totalPrice = "0";

    //Attributes
        @Autowired
        private InvoiceService invoiceService;

    //getInvoice
        @GetMapping("/getInvoice")
        public Set<Invoice> getInvoice()
    {
        return this.invoiceService.getInvoice();
    }

    //saveInvoice
        @PostMapping("/saveInvoice")
        public boolean saveInvoice(@RequestParam("studentNumber") String studentNumber, @RequestParam("eventCode") String eventCode, @RequestParam("totalPrice") String totalPrice)
        {
            if(eventCode != "") {
                this.eventCode = eventCode;

                double basePrice = Double.parseDouble(this.totalPrice);
                double addPrice = Double.parseDouble(totalPrice);
                double totalEventPrice = basePrice + addPrice;
                this.totalPrice = String.valueOf(totalEventPrice);

                String id = GenericHelper.getUniqueId();
                GenericSession.setInvoiceNum(id);
            }

            if(studentNumber != "") {
                this.studentNumber = studentNumber;
            }

            if(this.studentNumber != null && this.eventCode != null)
            {
                double invoicePrice = Double.parseDouble(this.totalPrice);
                double invoiceLinePrice = Double.parseDouble(GenericSession.getPrice());
                double allTotalPrice = invoicePrice + invoiceLinePrice;
                this.totalPrice = String.valueOf(allTotalPrice);

                Invoice invoice = InvoiceFactory.createInvoice(GenericSession.getInvoiceNum(), GenericHelper.getDate(), this.studentNumber, this.eventCode, this.totalPrice);
                this.eventCode = null;
                this.studentNumber = null;
                this.totalPrice = "0";
                return this.invoiceService.saveInvoice(invoice);
            }

            return false;
        }
}//end of class
