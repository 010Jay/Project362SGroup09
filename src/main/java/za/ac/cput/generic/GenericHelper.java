package za.ac.cput.generic;

import java.util.UUID;

public class GenericHelper {

    public static String getUniqueId()
    {
        return UUID.randomUUID().toString();
    }

    public static String getDate()
    {
        return java.util.Calendar.getInstance().getTime().toString();
    }

}
