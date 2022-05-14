package com.stulsoft.templates.controller;

import com.stulsoft.templates.data.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/user")
    ResponseEntity<User> user(){
        return ResponseEntity.ok(new User("test user", 21));
    }

    @GetMapping("/user2")
    ResponseEntity user2(){
        return ResponseEntity.ok(new User("test user", 21));
    }

    @GetMapping("/userError")
    ResponseEntity<User> userError(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/userError2")
    ResponseEntity userError2(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong params");
    }
}
