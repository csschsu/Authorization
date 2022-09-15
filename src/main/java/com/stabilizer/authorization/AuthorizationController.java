package com.stabilizer.authorization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.tmf632.model.*;
import io.swagger.tmf669.model.*;

@RestController
public class AuthorizationController {
    @RequestMapping(value = "/hello")
    public String hello() {
        Individual individual = new Individual();
        individual.setFamilyName("Christer");
        PartyRole pr = new PartyRole();
        pr.name("administrator");
        return "Hello World " + individual.getFamilyName() + " " + pr.getName();
    }
    @PostMapping("/createparty")
    public String createParty(@RequestBody String request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Individual individual = mapper.readValue(request, Individual.class);
        return "Hello " + individual.getFamilyName() +"\n";
    }
}
