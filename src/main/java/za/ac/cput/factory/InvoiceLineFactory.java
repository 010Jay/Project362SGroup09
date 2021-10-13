package za.ac.cput.factory;

/**
 * InvoiceLineFactory.java
 * Factory class for the Invoice Line
 * Author: Siyanda Hlongwa (217091229)
 * Date: 14 September 2021
 **/

import za.ac.cput.entity.InvoiceLine;

public class InvoiceLineFactory {

    public static InvoiceLine createInvoice(String invoiceLineNumber, String invoiceNumber, String foodId, String bevCode, String foodQuantity, String bevQuantity, String price)
    {
        return new InvoiceLine.Builder().setInvoiceLineNumber(invoiceLineNumber)
                                        .setInvoiceNumber(invoiceNumber)
                                        .setFoodId(foodId)
                                        .setBevCode(bevCode)
                                        .setFoodQuantity(foodQuantity)
                                        .setBevQuantity(bevQuantity)
                                        .setPrice(price)
                                        .build();
    }
}
