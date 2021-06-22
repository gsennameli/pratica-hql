package com.example.praticahql.controllers;

import com.example.praticahql.dtos.UserPasswordDTO;
import com.example.praticahql.models.User;
import com.example.praticahql.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
    }

    @GetMapping("/name/{substring}")
    public ResponseEntity<List<User>> findByNameContains(@PathVariable String substring){
        return new ResponseEntity<>(userService.findByNameContains(substring),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUserPassword(@RequestBody UserPasswordDTO userPasswordDTO){
        return new ResponseEntity<>(userService.updateUserPassword(userPasswordDTO),HttpStatus.OK);
        //return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.removeUser(id),HttpStatus.OK);
    }

}
