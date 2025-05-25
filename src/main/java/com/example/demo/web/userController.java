package com.example.demo.web;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("api/public")
    public class userController {
        private UserRepository userRepository;

        public userController(UserRepository userRepository) {
            this.userRepository = userRepository;}


    @GetMapping("test")
    public String test1(){
        return "Api test";
    }
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }
    @GetMapping("admin/users")
        public List<User> users(){
            return this.userRepository.findAll();
        }
    }