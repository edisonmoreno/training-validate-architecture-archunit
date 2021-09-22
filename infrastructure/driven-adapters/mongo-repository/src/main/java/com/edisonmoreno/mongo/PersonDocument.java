package com.edisonmoreno.mongo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
public class PersonDocument {
    @Id
    private String id;
    private String name;
    private String lastname;
}
