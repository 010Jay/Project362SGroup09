package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * InvoiceLine.java
 * Entity for the Invoice Line
 * Author: Siyanda Hlongwa (217091229)
 * Date: 14 September 2021
 **/

@Entity
public class InvoiceLine {//start of class

    @Id
    //Attributes
    private String invoiceLineNumber;
    private String invoiceNumber, foodId, bevCode, foodQuantity, bevQuantity, price;

    protected InvoiceLine(){};

    public InvoiceLine(Builder builder){
        this.invoiceLineNumber = builder.invoiceLineNumber;
        this.invoiceNumber = builder.invoiceNumber;
        this.foodId = builder.foodId;
        this.bevCode = builder.bevCode;
        this.foodQuantity = builder.foodQuantity;
        this.bevQuantity = builder.bevQuantity;
        this.price = builder.price;
    }

    //Getters
    public String getInvoiceLineNumber() {
        return invoiceLineNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getBevCode() {
        return bevCode;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public String getBevQuantity() {
        return bevQuantity;
    }

    public String getPrice() {
        return price;
    }

    //Setters
    public void setInvoiceLineNumber(String invoiceLineNumber) {
        this.invoiceLineNumber = invoiceLineNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public void setBevCode(String bevCode) {
        this.bevCode = bevCode;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void setBevQuantity(String bevQuantity) {
        this.bevQuantity = bevQuantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //toString
    @Override
    public String toString() {
        return "InvoiceLine{" +
                "invoiceLineNumber='" + invoiceLineNumber + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", foodId='" + foodId + '\'' +
                ", bevCode='" + bevCode + '\'' +
                ", foodQuantity='" + foodQuantity + '\'' +
                ", bevQuantity='" + bevQuantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static class Builder{

        //Attributes
        private String invoiceLineNumber, invoiceNumber, foodId, bevCode, foodQuantity, bevQuantity, price;

        public Builder setInvoiceLineNumber(String invoiceLineNumber) {
            this.invoiceLineNumber = invoiceLineNumber;
            return this;
        }

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder setFoodId(String foodId) {
            this.foodId = foodId;
            return this;
        }

        public Builder setBevCode(String bevCode) {
            this.bevCode = bevCode;
            return this;
        }

        public Builder setFoodQuantity(String foodQuantity) {
            this.foodQuantity = foodQuantity;
            return this;
        }

        public Builder setBevQuantity(String bevQuantity) {
            this.bevQuantity = bevQuantity;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public InvoiceLine build()
        {
            return new InvoiceLine(this);
        }

        public Builder copy(InvoiceLine invoiceLine)
        {
            this.invoiceLineNumber = invoiceLine.invoiceLineNumber;
            this.invoiceNumber = invoiceLine.invoiceNumber;
            this.foodId = invoiceLine.foodId;
            this.bevCode = invoiceLine.bevCode;
            this.foodQuantity = invoiceLine.foodQuantity;
            this.bevQuantity = invoiceLine.bevQuantity;
            this.price = invoiceLine.price;

            return this;
        }
    }
}//end of class
