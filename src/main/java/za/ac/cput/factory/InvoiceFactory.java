package za.ac.cput.factory;

import za.ac.cput.entity.Invoice;

/**
 * InvoiceFactory.java
 * Factory class for the Invoice
 * Author: Siyanda Hlongwa (217091229)
 * Date: 14 September 2021
 **/

public class InvoiceFactory {

    public static Invoice createInvoice(String invoiceNumber, String invoiceDate, String studentNumber, String eventCode, String totalPrice)
    {
        return new Invoice.Builder().setInvoiceNumber(invoiceNumber)
                                    .setInvoiceDate(invoiceDate)
                                    .setStudentNumber(studentNumber)
                                    .setEventCode(eventCode)
                                    .setTotalPrice(totalPrice)
                                    .build();
    }
}
