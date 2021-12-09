/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.repository;

import com.usa.c4reto01.crud.UserCrudRepository;
import com.usa.c4reto01.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alberto
 */

@Repository
public class UserRepository{
    
    @Autowired
    private UserCrudRepository repository;
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
    public Optional<User> getById(Integer id){
        return repository.findById(id);
    }
    
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    public User save(User user){
        return repository.save(user);
    } 
    
    public void delete(Integer id){
        repository.deleteById(id);
    }
    
    public List<User> getUserByIdOrEmailOrName(Integer id,String email,String name){
        return repository.findByIdOrEmailOrName(id, email, name);
    }
    
}
