package com.edisonmoreno.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<PersonDocument, String>, ReactiveQueryByExampleExecutor<PersonDocument> {
    Flux<PersonDocument> findByName(String name);
}
