package com.dilemma.dilemma.repository.user;

import com.dilemma.dilemma.entity.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by aslan.atasoy on 09/27/2017.
 */
public interface UserRepository extends MongoRepository<User,String>,CrudRepository<User,String> {
    List<User> findByFirstNameStartsWithIgnoreCase(String name);
}
