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
    private final WishesService wishesService;

    public UserResources(UserDetailsServiceImpl userDetailsServiceImpl, WishesService wishesService) {this.userDetailsServiceImpl = userDetailsServiceImpl; this.wishesService = wishesService;}

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser () {
        List<User> user = userDetailsServiceImpl.findAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
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
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userDetailsServiceImpl.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/wishes/add/{id}")
    public ResponseEntity<?> addWishes(@PathVariable("id") Long id ){
        return wishesService.addWish(id);
    }




}
