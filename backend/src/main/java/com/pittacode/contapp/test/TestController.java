package com.pittacode.contapp.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/test")
public class TestController {


    @RequestMapping(path = "/ping", method = GET)
    public String greeting(@RequestParam(required = true, name = "name") String name, @RequestParam(required = false, name = "surname") String lastName) {
        return lastName == null
                ? "Hello " + name
                : "Hello " + name + " " + lastName;
    }
}


