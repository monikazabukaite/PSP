package com.lab3.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.lab3.lab.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
