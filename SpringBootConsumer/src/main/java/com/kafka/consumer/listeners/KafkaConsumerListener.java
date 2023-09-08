package com.kafka.consumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.entities.PersonEntity;
import com.kafka.consumer.model.PersonModel;
import com.kafka.consumer.service.IPersonService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @Autowired
    private IPersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "test-topic")
    public void consumePerson(ConsumerRecord<String, String> record) {

        LOGGER.info("RECIBE EL MENSAJE");
        try {
            String messageKey = record.key();
            String jsonPayload = record.value();

            PersonModel personModel = objectMapper.readValue(jsonPayload, PersonModel.class);

            LOGGER.debug("Received Kafka message. Key: {}, Value: {}", messageKey, personModel);

            PersonEntity person = new PersonEntity();
            person.setName(personModel.getName());
            person.setLastName(personModel.getLastName());
            person.setAge(Integer.valueOf(personModel.getAge()));
            person.setEmail(personModel.getEmail());
            person.setPhone(personModel.getPhone());

            LOGGER.info(person.toString());


            personService.savePerson(person);

            LOGGER.info("Received Message in group group-test: " + personModel);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error processing Kafka message: " + e.getMessage(), e);
        }
    }
}

