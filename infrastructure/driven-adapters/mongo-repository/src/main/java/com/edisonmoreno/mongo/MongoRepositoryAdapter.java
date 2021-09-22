package com.edisonmoreno.mongo;

import com.edisonmoreno.model.person.Person;
import com.edisonmoreno.model.person.gateways.PersonRepository;
import com.edisonmoreno.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Person, PersonDocument, String, MongoDBRepository> implements PersonRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Person.class));
    }

    @Override
    public Flux<Person> findByAll() {
        return repository.findAll().map(this::toEntity);
    }

    @Override
    public Flux<Person> findByName(String name) {
        return repository.findByName(name).map(this::toEntity);
    }
}
