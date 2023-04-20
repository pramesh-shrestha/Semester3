package com.rest.restfull_webservice.controller;

import com.rest.restfull_webservice.entity.Users;
import com.rest.restfull_webservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private IUserService service;

  @PostMapping ("/users")
  public ResponseEntity<Users> saveUser(@RequestBody
  Users user){
    try {
      return new ResponseEntity<>(service.postUser(user), HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/users")
  public ResponseEntity<List<Users>> getUsers(){
    try {
      return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Users> getUser(@PathVariable("id") int id){
    try {
      return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
    try {
      service.deleteUser(id);
      return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody Users user){
    try {
      System.out.println(user.getEmail());
      service.updateUser(id, user);
      return new ResponseEntity<>("User has been updated", HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
