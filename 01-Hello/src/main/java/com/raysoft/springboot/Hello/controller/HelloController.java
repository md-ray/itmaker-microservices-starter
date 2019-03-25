package com.raysoft.springboot.Hello.controller;

import com.raysoft.springboot.Hello.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/hello-customer", produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getCustomer(@RequestParam(value="id") Long id) {
        if (id == null) {
            return new ResponseEntity<Object>("Parameter ID not supplied", HttpStatus.BAD_REQUEST);
        }
        Customer c = new Customer();
        ResponseEntity<Object> resp = null;

        if (id == 0) {
            c.setName("Customer with ID = 0");
            resp = new ResponseEntity<Object>(c, HttpStatus.OK);
        } else {
            c.setName("#itmaker");
            resp = new ResponseEntity<Object>(c, HttpStatus.OK);
        }
        return resp;
    }
}