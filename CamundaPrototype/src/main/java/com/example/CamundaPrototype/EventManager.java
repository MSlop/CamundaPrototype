package com.example.CamundaPrototype;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EventManager implements CommandLineRunner {

    public static void main(String[] args){
        SpringApplication.run(EventManager.class, args);
    }

    @Autowired
    private ZeebeClient client;

    @Override
    public void run(String... args) throws Exception{

        final Map<String, Object> variables = new HashMap<String, Object>();

        // Fill data
        variables.put("objectKey","112233");
        variables.put("policyNumber","100");
        variables.put("caseType","Value");

        // Send event messageName = "CreateClaim" with variables = variables
        String messageKey = "ID1";
        client.newPublishMessageCommand().messageName("CreateClaim1").correlationKey(messageKey).variables(variables)
                .send()
                .exceptionally( throwable -> { throw new RuntimeException( "Not message", throwable); } );
    }
}
