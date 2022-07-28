package com.platzi.springboot.fundamentos.controller;

import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/paging")
    public List<User> getUserByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return  userService.getUserByPage(page, pageSize);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.update(newUser, id), HttpStatus.OK);
    }

}
