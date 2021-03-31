package com.example.restfulservices.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min=2)
    private String name;

    @Past
    private Date joinDate;
}
