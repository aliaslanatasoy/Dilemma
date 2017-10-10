package com.dilemma.dilemma.service.user;

import com.dilemma.dilemma.entity.user.User;
import com.dilemma.dilemma.repository.user.UserRepository;
import com.dilemma.dilemma.security.AuthUser;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aslan.atasoy on 09/27/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> addUser(User user) throws Exception{
        User savedUser = null;
        ResponseEntity<User> userResponseEntity;

        try {
            savedUser = userRepository.save(user);
            userResponseEntity = new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
        } catch (Exception e) {
            userResponseEntity = new ResponseEntity<User>(user,HttpStatus.CONFLICT);
        }


        return userResponseEntity;
    }

    public ResponseEntity<List<User>> getUserByName(String name){
        return new ResponseEntity<List<User>>(userRepository.findByFirstNameStartsWithIgnoreCase(name),HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(User user){


        if(userRepository.findOne(user.getUserId()) != null){
            User retrievedUser = userRepository.findOne(user.getUserId());
            retrievedUser = user;
            return new ResponseEntity<User>(userRepository.save(retrievedUser),HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> deleteUser(User user){
        if(userRepository.findOne(user.getUserId()) != null){
            User retrievedUser = userRepository.findOne(user.getUserId());
            retrievedUser = user;
            userRepository.delete(retrievedUser);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }


}
