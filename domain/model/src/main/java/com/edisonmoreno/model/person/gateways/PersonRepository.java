package com.edisonmoreno.model.person.gateways;

import com.edisonmoreno.model.person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> findById(String id);

    Flux<Person> findByAll();

    Flux<Person> findByName(String name);
}
