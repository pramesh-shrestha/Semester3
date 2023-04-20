package com.rest.restfull_webservice.service;

import com.rest.restfull_webservice.entity.Users;

import java.util.List;

public interface IUserService {
  Users postUser(Users user);
  Users getUser(Integer id);
  List<Users> getAllUsers();
  void deleteUser(Integer id);
  Users updateUser(int id, Users user);
}
