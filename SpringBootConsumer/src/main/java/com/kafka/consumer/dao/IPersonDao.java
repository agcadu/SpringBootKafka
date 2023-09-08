package com.kafka.consumer.dao;

import com.kafka.consumer.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDao extends CrudRepository<PersonEntity, Long> {
}
