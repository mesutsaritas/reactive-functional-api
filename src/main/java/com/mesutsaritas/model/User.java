package com.mesutsaritas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/**
 * @author msaritas
 *
 */
@Setter
@Getter
@Document
public class User {

    @Id
    private Long id;

    @Indexed(unique = true)
    @Field("identityNumber")
    private String identityNumber;

    @Field("name")
    private String name;

    @Field("lastName")
    private String lastName;

    @Field("address")
    private String address;

}
