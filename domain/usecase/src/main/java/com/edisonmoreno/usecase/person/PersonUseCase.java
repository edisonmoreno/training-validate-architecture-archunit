package com.edisonmoreno.usecase.person;

import com.edisonmoreno.model.person.Person;
import com.edisonmoreno.model.person.gateways.PersonRepository;
import com.edisonmoreno.model.person.gateways.PersonService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonUseCase {
    private final PersonService serviceGateway;
    private final PersonRepository repositoryGateway;

    public Mono<Person> getPerson(String id) {
        return repositoryGateway.findById(id).defaultIfEmpty(Person.builder().name("NOT_FOUND").build());
    }

    public Flux<Person> getAll() {
        return repositoryGateway.findByAll();
    }

    public Flux<Person> getPersonByName(String name) {
        return repositoryGateway.findByName(name);
    }

    public Mono<Person> getPersonService(String id) {
        return serviceGateway.getPerson(id);
    }

    public Mono<Float> getBalanceService(String id) {
        return serviceGateway.getBalance(id);
    }

}
