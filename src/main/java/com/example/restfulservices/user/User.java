package com.example.restfulservices.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private Date joinDate;
}
