package com.kafka.provider.controller;

import com.kafka.provider.model.Person;
import com.kafka.provider.response.PersonResponseRest;
import com.kafka.provider.service.IPersonService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private IPersonService personService;

    @PostMapping("/person")
    public ResponseEntity<PersonResponseRest> sendMessage(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") String age,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone
    ) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);
        person.setEmail(email);
        person.setPhone(phone);
        ProducerRecord<String, Person> personRecord = new ProducerRecord<>("test-topic", person);

        ResponseEntity<PersonResponseRest> response = personService.sendMessage(personRecord);

        LOGGER.info("PersonController.sendMessage response: {}", response + " " + person);



        return response;

    }
}
