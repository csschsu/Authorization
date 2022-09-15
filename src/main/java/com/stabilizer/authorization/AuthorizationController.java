package com.stabilizer.authorization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.tmf632.model.*;
import io.swagger.tmf669.model.*;
import java.util.Random;

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
        return "Hello " + individual.getFamilyName() + "\n";
    }

    @PostMapping("/createindividual")
    public String createindividual(@RequestBody String request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Individual individual = mapper.readValue(request, Individual.class);
        insert(individual.getFamilyName());
        return "Done\n";
    }

    public void insert(String data) {
        try (MongoClient mongoClient = MongoClients.create(connectionString())) {

            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("inventory");

            Random rand = new Random();
            Document student = new Document("_id", new ObjectId());
            student.append("item", 20003d)
                    .append("qty", 200d)
            .append("data", data);
            gradesCollection.insertOne(student);
        }
    }
            public static String connectionString (){
            return "mongodb://localhost:27017";
            }
    }