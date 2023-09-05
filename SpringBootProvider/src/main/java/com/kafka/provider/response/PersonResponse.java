package com.kafka.provider.response;

import com.kafka.provider.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonResponse {

    List<Person> persons;
}
