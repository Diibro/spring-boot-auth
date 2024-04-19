package com.authenticationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authenticationsystem.model.User;
import com.authenticationsystem.service.UserService;
import com.authenticationsystem.utils.MessageReturn;

@RestController
@RequestMapping(value = "/user")
public class UserController {
     @Autowired
     private UserService userService;

     @PostMapping(
          value = "/save", 
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
     )
     public ResponseEntity<?> saveUser(@RequestBody User user){
          MessageReturn res = userService.save(user);
          if(res.isDone()){
               return new ResponseEntity<>(res.getMessage(), HttpStatus.ACCEPTED);
          }else{
               return new ResponseEntity<>(res.getMessage(), HttpStatus.NOT_ACCEPTABLE);
          }
     }

     @PostMapping(
          value = "/update", 
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
     )
     public ResponseEntity<?> updateUser(@RequestBody User user){
          MessageReturn res = userService.update(user);
          if(res.isDone()){
               return new ResponseEntity<>(res.getMessage(), HttpStatus.ACCEPTED);
          }else{
               return new ResponseEntity<>(res.getMessage(), HttpStatus.NOT_ACCEPTABLE);
          }
     }

     @DeleteMapping(
          value = "/delete", 
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
     )
     public ResponseEntity<?> deleteUser(@RequestBody User user){
          MessageReturn res = userService.delete(user);
          if(res.isDone()){
               return new ResponseEntity<>(res.getMessage(), HttpStatus.ACCEPTED);
          }else{
               return new ResponseEntity<>(res.getMessage(), HttpStatus.NOT_ACCEPTABLE);
          }
     }

     @GetMapping(value = "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> findAll(){
          List<User> users = userService.findAll();
          return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
     }

}
