package com.kafka.provider.service;

import com.kafka.provider.model.Person;
import com.kafka.provider.response.PersonResponseRest;
import org.springframework.http.ResponseEntity;

public interface IPersonService {

    public ResponseEntity<PersonResponseRest> sendMessage(Person person);
}
