package com.kafka.provider.service;

import com.kafka.provider.model.Person;
import com.kafka.provider.response.PersonResponseRest;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    @Override
    public ResponseEntity<PersonResponseRest> sendMessage(ProducerRecord<String, Person> person) {
        PersonResponseRest response = new PersonResponseRest();
        List<Person> list = new ArrayList<>();

        kafkaTemplate.send(person.topic(), person.key(), person.value());
        list.add(person.value());
        response.getPerson().setPersons(list);
        response.setMetadata("OK", "00", "Mensaje enviado");


        return new ResponseEntity<PersonResponseRest>(response, HttpStatus.OK);
    }

}
