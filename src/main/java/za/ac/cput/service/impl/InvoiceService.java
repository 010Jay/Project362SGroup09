package za.ac.cput.service.impl;

/**
 * InvoiceLineService.java
 * Service implementation class for the Invoice
 * Author: Siyanda Hlongwa(217091229)
 * Date: 23 September 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.IInvoiceService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceService implements IInvoiceService
{//start of class

    @Autowired
    private InvoiceRepository repository;
    private static InvoiceService service = null;

    public static InvoiceService getService() {

        if(service == null)
        {
            service = new InvoiceService();
        }

        return service;
    }
    @Override
    public Set<Invoice> getInvoice() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public boolean saveInvoice(Invoice invoice) {
    Invoice result = this.repository.save(invoice);
    if( result != null)
    {
        return true;
    }
    return false;

    }


}//end of class
