package com.kafka.provider.service;

import com.kafka.provider.model.Person;
import com.kafka.provider.response.PersonResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    @Override
    @Transactional
    public ResponseEntity<PersonResponseRest> sendMessage(Person person) {

        PersonResponseRest response = new PersonResponseRest();
        List<Person> list = new ArrayList<>();

        kafkaTemplate.send("test-topic", person);
        list.add(person);
        response.getPerson().setPersons(list);
        response.setMetadata("OK", "00", "Mensaje enviado");


        return new ResponseEntity<PersonResponseRest>(response, HttpStatus.OK);
    }
}
