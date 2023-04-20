package com.rest.restfull_webservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
  @Id
  @GeneratedValue
  private int id;
  private String email;
  private String password;

  public Users(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Users() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
