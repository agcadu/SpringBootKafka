package com.kafka.consumer.service;

import com.kafka.consumer.entities.PersonEntity;


public interface IPersonService {

    void savePerson(PersonEntity person);
}
