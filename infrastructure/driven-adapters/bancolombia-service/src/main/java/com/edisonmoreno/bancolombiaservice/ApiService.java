package com.edisonmoreno.bancolombiaservice;

import com.edisonmoreno.model.person.Person;
import com.edisonmoreno.model.person.gateways.PersonService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class ApiService implements PersonService {
    @Override
    public Mono<Person> getPerson(String id) {
        return Mono.just(Person.builder()
                        .id(id)
                        .balance(60111222f)
                .build());
    }

    @Override
    public Mono<Float> getBalance(String id) {
        return Mono.just(1999888f);
    }
}
