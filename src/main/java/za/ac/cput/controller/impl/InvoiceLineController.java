package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Invoice;
import za.ac.cput.entity.InvoiceLine;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.factory.InvoiceLineFactory;
import za.ac.cput.generic.GenericHelper;
import za.ac.cput.generic.GenericSession;
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

    private String foodId, bevCode, foodQuantity, bevQuantity;
    private String price = "0";

    //Attributes
        @Autowired
        private InvoiceLineService invoiceLineService;

    //saveInvoice
        @PostMapping("/saveInvoiceLineDetails")
        public boolean saveInvoiceLineDetails(@RequestParam String foodId, @RequestParam String bevCode, @RequestParam String foodQuantity, @RequestParam String bevQuantity, @RequestParam String price)
        {
            if(foodId != "" && foodQuantity != "") {
                this.foodId = foodId;
                this.foodQuantity = foodQuantity;

                double basePrice = Double.parseDouble(this.price);
                double addPrice = Double.parseDouble(price);
                double totalFoodPrice = basePrice + addPrice;
                this.price = String.valueOf(totalFoodPrice);
            }

            if(bevCode != "" && bevQuantity != "") {
                this.bevCode = bevCode;
                this.bevQuantity = bevQuantity;

                double basePrice1 = Double.parseDouble(this.price);
                double addPrice1 = Double.parseDouble(price);
                double totalBevPrice = basePrice1 + addPrice1;
                this.price = String.valueOf(totalBevPrice);
            }

            if(this.foodId != null && this.bevCode != null && foodQuantity != null && bevQuantity != null)
            {
                GenericSession.setPrice(this.price);
                InvoiceLine invoiceLine = InvoiceLineFactory.createInvoice(GenericHelper.getUniqueId(), GenericSession.getInvoiceNum(), this.foodId, this.bevCode, this.foodQuantity, this.bevQuantity, this.price);
                this.foodId = null;
                this.bevCode = null;
                this.foodQuantity = null;
                this.bevQuantity = null;
                this.price = "0";
                return this.invoiceLineService.saveInvoiceLineDetails(invoiceLine);
            }

            return false;
        }

}//end of class
