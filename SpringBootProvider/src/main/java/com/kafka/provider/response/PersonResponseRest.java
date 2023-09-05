package com.kafka.provider.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseRest extends ResponseRest{

    private PersonResponse person = new PersonResponse();

}
