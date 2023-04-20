package com.rest.restfull_webservice;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(Integer id){
    super("User with id " + id + "not found.");
  }
}
