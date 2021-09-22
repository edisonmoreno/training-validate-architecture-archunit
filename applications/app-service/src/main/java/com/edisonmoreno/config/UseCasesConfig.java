package com.edisonmoreno.config;

import com.edisonmoreno.model.person.gateways.PersonRepository;
import com.edisonmoreno.model.person.gateways.PersonService;
import com.edisonmoreno.usecase.person.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.edisonmoreno.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

    @Bean
    public PersonUseCase getPersonUseCase(PersonService serviceGateway, PersonRepository personRepository) {
        return new PersonUseCase(serviceGateway, personRepository);
    }
}
