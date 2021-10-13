package za.ac.cput.controller.impl;

/**
 * LoginController.java
 * Controller for the Login Service
 * Author: Jason Jaftha (217009301)
 * Date: 4 October 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Login;
import za.ac.cput.service.impl.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    //Attributes
        @Autowired
        private LoginService loginService;

    @PostMapping("/getLoginDetails")
    public boolean getLoginDetails(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        return this.loginService.getLoginDetails(username, password);
    }

    @PostMapping("/saveRegistrationDetails")
    public boolean saveRegistrationDetails(@RequestBody Login login)
    {
        return this.loginService.saveRegistrationDetails(login);
    }

}
