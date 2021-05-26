package com.example.restfulservices.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    private UserDaoService service ;

    public AdminUserController(UserDaoService service ){
        this.service = service;
    }

    /**
     *  전체 사용자 목록 조회.
     * @return
     */
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers(){

        List<User> userAll = service.findAll();

        //  특정 필드만 노출.
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserInfo",simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userAll);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    /**
     *  특정 사용자 조회.
     * @param id
     * @return
     */
//    @GetMapping("/v1/users/{id}")
//    @GetMapping(value = "/users/{id}", params = "version=1")
//    @GetMapping(value = "/users/{id}",headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}",produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //  특정 필드만 노출.
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserInfo",simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        mappingJacksonValue.setFilters(filterProvider);


        return mappingJacksonValue;
    }

    //  버전별로 api 관리.종류 ( url, param, headers, media type )
    //  추가로 필드 추가
//    @GetMapping("/v2/users/{id}")
//    @GetMapping(value = "/users/{id}", params = "version=2")
//    @GetMapping(value = "/users/{id}",headers = "X-API-VERSION=2")
    @GetMapping(value = "/users/{id}",produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveUserv2(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user,userV2);
        userV2.setGrade("VIP");

        //  특정 필드만 노출.
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn","grade");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserInfoV2",simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userV2);
        mappingJacksonValue.setFilters(filterProvider);


        return mappingJacksonValue;
    }
}
