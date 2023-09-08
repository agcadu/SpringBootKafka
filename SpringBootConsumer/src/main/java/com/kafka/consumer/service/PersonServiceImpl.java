package com.kafka.consumer.service;

import com.kafka.consumer.dao.IPersonDao;
import com.kafka.consumer.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonDao personDao;

    @Override
    @Transactional
    public void savePerson(PersonEntity person) {

        personDao.save(person);
    }
}
