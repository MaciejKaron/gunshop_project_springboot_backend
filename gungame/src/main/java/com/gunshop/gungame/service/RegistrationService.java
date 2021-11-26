package com.gunshop.gungame.service;

import com.gunshop.gungame.model.User;
import com.gunshop.gungame.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepo registrationRepo;

    @Autowired
    public RegistrationService(RegistrationRepo registrationRepo){
        this.registrationRepo = registrationRepo;
    }

    public User addUser(User user){
        return registrationRepo.save(user);
    }

    public List<User> findAllUsers(){
        return registrationRepo.findAll();
    }

    public User updateUser(User user){
        return registrationRepo.save(user);
    }

    public void deleteUser(Long id){
        registrationRepo.deleteById(id);
    }

}
