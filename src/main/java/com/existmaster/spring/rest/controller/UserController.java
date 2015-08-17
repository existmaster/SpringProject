package com.existmaster.spring.rest.controller;

import com.existmaster.spring.repository.UserRepository;
import com.existmaster.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by existmaster on 2015. 6. 18..
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("list")
    public List<User> listupUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }


    @RequestMapping("search/{userId}")
    public User getUser(@PathVariable String userId){
        User user = userRepository.findOne(userId);
        return user;
    }

    @RequestMapping("add")
    public User addUser(@RequestParam(value="userId") String userId, @RequestParam(value="password") String password){
        User user = userRepository.save(new User(userId, password));
        return user;
    }

    @RequestMapping("del/{userId}")
    public String delUser(@PathVariable String userId){
        userRepository.delete(userId);
        return "Delete Complete!!";
    }

    @RequestMapping("mod/{userId}")
    public User modUser(@PathVariable String userId, @RequestParam(value="password") String password){
        User user = new User(userId, password);
        userRepository.save(user);
        return user;
    }

}
