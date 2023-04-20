package com.rest.restfull_webservice.service;

import com.rest.restfull_webservice.UserNotFoundException;
import com.rest.restfull_webservice.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.restfull_webservice.repository.IUserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private IUserRepository repository;

  @Override
  public Users postUser(Users user) {
    return repository.save(user);
  }

  @Override
  public Users getUser(Integer id) {
    return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public List<Users> getAllUsers() {
    return repository.findAll();
  }

  @Override
  public void deleteUser(Integer id) {
    repository.deleteById(id);
  }

  @Override
  public Users updateUser(int id, Users user) {
//    Optional<Users> existingUser = Optional.of(repository.findById(id).get());
//    System.out.println(existingUser);
//
//      existingUser.map( user1 -> {
//        user1.setEmail(user.getEmail());
//        user1.setPassword(user.getPassword());
//        return repository.save(user1);
//      });
//    return user;
    System.out.println(user.getEmail()+ " " + user.getPassword());
    Users user1 = repository.findById(id).get();

    if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())){
      user1.setEmail(user.getEmail());
    }
    if(Objects.nonNull(user.getPassword()) && !"".equals(user.getPassword())){
      user1.setPassword(user.getPassword());
    }
    System.out.println(user1.getEmail() + " " + user1.getPassword());
    return repository.save(user1);
  }
}
