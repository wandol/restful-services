package com.example.restfulservices.user;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    /**
     *  사용자 추가.
     * @param user
     */
    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));
    }
}
