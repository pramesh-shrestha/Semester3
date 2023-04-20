package com.rest.restfull_webservice.repository;

import com.rest.restfull_webservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
}
