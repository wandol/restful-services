package com.example.restfulservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    //  get
    //  /hello-world ( endpoint )
    //  @RequestMapping( method=RequestMethod.GET, path="/hello-world"" )
    @GetMapping("/hello-world" )
    public String helloWorld(){
        return "Hello-world";
    }

    @GetMapping("/hello-world-bean" )
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/pv/{name}" )
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s" , name));
    }

    @GetMapping("/hello-world-in")
    public String helloIn(@RequestHeader(name = "Accept-Language", required = false)  Locale locale){
        return  messageSource.getMessage("greeting.message",null,locale);
    }
}
