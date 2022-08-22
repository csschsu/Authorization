package com.stabilizer.authorization;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.tmf632.model.*;
import io.swagger.tmf669.model.*;


@RestController
public class AuthorizationController {
    @RequestMapping(value = "/hello")
    public String hello() {
        Individual individ = new Individual();
        individ.setFamilyName("Christer");
        PartyRole pr = new PartyRole();
        pr.name("administrator");
        return "Hello World " + individ.getFamilyName() + " " + pr.getName();
    }
}
