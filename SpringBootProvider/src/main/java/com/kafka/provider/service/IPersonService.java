package com.kafka.provider.service;

import com.kafka.provider.model.Person;
import com.kafka.provider.response.PersonResponseRest;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface IPersonService {

    public ResponseEntity<PersonResponseRest> sendMessage(ProducerRecord <String,Person> person);


}
