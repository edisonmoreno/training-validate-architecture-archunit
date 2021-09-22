package com.edisonmoreno.api;

import com.edisonmoreno.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final PersonUseCase personUseCase;

    public Mono<ServerResponse> getPerson(ServerRequest serverRequest) {
        return personUseCase.getPerson(serverRequest.pathVariable("id"))
                .flatMap(person -> ServerResponse
                        .ok()
                        .bodyValue(person)
                );
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return personUseCase.getAll()
                .collectList()
                .flatMap(person -> ServerResponse
                        .ok()
                        .bodyValue(person)
                );
    }

    public Mono<ServerResponse> getPersonByName(ServerRequest serverRequest) {
        return personUseCase.getPersonByName(serverRequest.pathVariable("name"))
                .collectList()
                .flatMap(person -> ServerResponse
                        .ok()
                        .bodyValue(person)
                );
    }
}
