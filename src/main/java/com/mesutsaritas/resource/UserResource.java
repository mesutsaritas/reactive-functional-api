package com.mesutsaritas.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author msaritas
 *
 */

@Setter
@Getter
public class UserResource implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String identityNumber;

    private String name;

    private String lastName;

    private String address;

}
