package com.edisonmoreno.model.person.gateways;

import com.edisonmoreno.model.person.Person;
import reactor.core.publisher.Mono;

public interface PersonService {
    Mono<Person> getPerson(String id);
    Mono<Float> getBalance(String id);
}
