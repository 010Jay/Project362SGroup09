package za.ac.cput.service.impl;

/**
 * InvoiceLineService.java
 * Service implementation class for the InvoiceLine
 * Author: Siyanda Hlongwa(217091229)
 * Date: 23 September 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.InvoiceLine;
import za.ac.cput.repository.InvoiceLineRepository;
import za.ac.cput.service.IInvoiceLineService;

@Service
public class InvoiceLineService implements IInvoiceLineService
{//start of class

    //Attributes
    @Autowired
    private InvoiceLineRepository repository;
    private static InvoiceLineService service = null;

    public static InvoiceLineService getService() {

        if(service == null)
        {
            service = new InvoiceLineService();
        }

        return service;
    }

    @Override
    public boolean saveInvoiceLineDetails(InvoiceLine invoiceLine) {
        if(invoiceLine != null)
        {
            this.repository.save(invoiceLine);
            return true;
        }

        return false;
    }

}//end of class
