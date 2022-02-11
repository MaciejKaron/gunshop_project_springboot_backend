package com.gunshop.gungame;


import com.gunshop.gungame.model.User;
import com.gunshop.gungame.service.UserDetailsServiceImpl;
import com.gunshop.gungame.service.WishesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResources {
    private final UserDetailsServiceImpl userDetailsServiceImpl;


    public UserResources(UserDetailsServiceImpl userDetailsServiceImpl) {this.userDetailsServiceImpl = userDetailsServiceImpl;}

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser () {
        List<User> user = userDetailsServiceImpl.findAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userDetailsServiceImpl.findUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userDetailsServiceImpl.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userDetailsServiceImpl.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userDetailsServiceImpl.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upd/{id}")
    public ResponseEntity<User> updUser(@PathVariable("id") Long id, @RequestBody User user) {
        User updUser = userDetailsServiceImpl.findUserById(id);
        updUser.setUsername(user.getUsername());
        updUser.setEmail(user.getEmail());
        updUser.setPassword(user.getPassword());
        updUser.setAvatar(user.getAvatar());
        updUser.setRoles(user.getRoles());
        userDetailsServiceImpl.updateUser(updUser);
        return ResponseEntity.ok(updUser);
    }






}
