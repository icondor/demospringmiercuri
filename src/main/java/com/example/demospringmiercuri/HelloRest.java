package com.example.demospringmiercuri;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hellorest")
public class HelloRest {


    @GetMapping(value ="/{username}", produces= MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<?> hello(@PathVariable String username) {
        //validari
        // salvare in db
        // algoritmi
        return new ResponseEntity<>("Salut domnule/doamna <b>"+username+"</b>", HttpStatus.OK);
    }
}
