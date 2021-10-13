package za.ac.cput.service;

import za.ac.cput.entity.Invoice;
import java.util.Set;

/**
 * IInvoiceLineService.java
 * Service for IInvoice interface
 * Author: Siyanda Hlongwa(217091229)
 * Date: 23 September 2021
 **/

public interface IInvoiceService
{//start of class

    Set<Invoice> getInvoice();

    boolean saveInvoice(Invoice invoice);
}//end of class
