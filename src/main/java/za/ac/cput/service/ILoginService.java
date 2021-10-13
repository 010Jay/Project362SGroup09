package za.ac.cput.service;

import za.ac.cput.entity.Login;

/**
 * ILoginService.java
 * Service interface for the Login
 * Author: Jason Jaftha (217009301)
 * Date: 22 September 2021
 **/

public interface ILoginService {

    boolean getLoginDetails(String username, String password);

    boolean saveRegistrationDetails(Login login);

}
