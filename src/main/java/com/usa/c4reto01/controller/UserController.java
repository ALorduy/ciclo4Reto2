/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.controller;

import com.usa.c4reto01.model.User;
import com.usa.c4reto01.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alberto
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

/**
 * Controlador Usuario
 */
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> getUser(){
      return service.getAll();
    }
    
    @PostMapping("/new")   
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }
    
    @PutMapping("/update")   
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer id ){
        return service.delete(id);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email,@PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
   
}
