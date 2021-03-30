package com.example.restfulservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService service ;

    public UserController ( UserDaoService service ){
        this.service = service;
    }

    /**
     *  전체 사용자 목록 조회.
     * @return
     */
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    /**
     *  특정 사용자 조회.
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = service.save(user);
    }
}
