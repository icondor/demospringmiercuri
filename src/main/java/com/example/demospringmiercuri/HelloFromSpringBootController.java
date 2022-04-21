package com.example.demospringmiercuri;

// pattern MVC

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class HelloFromSpringBootController {

//    @GetMapping("/register")
//    public ResponseEntity<?> hello(@RequestParam(value="username", defaultValue = "") String u) {
//        //validari
//        // salvare in db
//        // algoritmi
//        return new ResponseEntity<>("Salut domnule/doamna "+u, HttpStatus.OK);
//    }
//
//    @GetMapping("/login")
//    public ResponseEntity<?> login(@RequestParam(value="username", defaultValue = "") String u) {
//        //validari
//        // citire dn db
//        // algoritmi
//        return new ResponseEntity<>("dghgfhj "+u, HttpStatus.OK);
//    }


    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path="/registerUser")
    public @ResponseBody String registerNewUser (@RequestParam String username, @RequestParam String password, @RequestParam String accOff) {

        //validari

        // ma apuc sa codez persistenta
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setOffers(Boolean.getBoolean(accOff));

        usersRepository.save(newUser);

        return "OK, done";
    }

    @GetMapping(path="/listUsers")
    public @ResponseBody Iterable<Users> listAllUsers() {
         return usersRepository.findAll();
    }

}
