package za.ac.cput.generic;

public class GenericSession {

    private static String invoiceNum;
    private static String price;
    private static GenericSession genericSession;

    public static GenericSession getSession()
    {
        if(genericSession == null)
        {
            genericSession = new GenericSession();
        }

        return genericSession;
    }

    public static String getInvoiceNum() {
        return invoiceNum;
    }

    public static String getPrice() {
        return price;
    }

    public static void setInvoiceNum(String invoiceNum) {
        GenericSession.invoiceNum = invoiceNum;
    }

    public static void setPrice(String price) {
        GenericSession.price = price;
    }
}
