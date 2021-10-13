package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Login;
import za.ac.cput.repository.LoginRepository;
import za.ac.cput.service.ILoginService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * LoginService.java
 * Service implementation class for the Login
 * Author: Jason Jaftha (217009301)
 * Date: 22 September 2021
 **/

@Service
public class LoginService implements ILoginService {

    //Attributes
        @Autowired
        private LoginRepository repository;
        private static LoginService service = null;

    //Singleton
        public static LoginService getService() {

            if(service == null)
            {
                service = new LoginService();
            }

            return service;
        }

    @Override
    public boolean getLoginDetails(String username, String password) {
       Set<Login> loginDetailList = this.repository.findAll().stream().collect(Collectors.toSet());

       for(Login login : loginDetailList)
        {
            if(username.equals(login.getUsername()) && password.equals(login.getPassword()))
            {
                return true;
            }
        }

       return false;
    }

    @Override
    public boolean saveRegistrationDetails(Login login) {
        Login loginResult = this.repository.save(login);

        if(loginResult != null)
        {
            return true;
        }

        return false;
    }


}
