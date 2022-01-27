package com.gunshop.gungame.service;

import com.gunshop.gungame.model.Equipment;
import com.gunshop.gungame.model.User;
import com.gunshop.gungame.repository.EquipmentRepository;
import com.gunshop.gungame.repository.UserRepository;
import com.gunshop.gungame.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class WishesService {

    private final UserRepository userRepository;
    private final EquipmentRepository equipmentRepository;
    private final JwtUtils jwtUtils;

    @Autowired
    public WishesService(UserRepository userRepository, EquipmentRepository equipmentRepository, JwtUtils jwtUtils ){
        this.userRepository = userRepository;
        this.equipmentRepository = equipmentRepository;
        this.jwtUtils = jwtUtils;
    }


    public ResponseEntity<?> addWish(Long id){
        User user = userRepository.findByUsername("piotrek").orElseThrow();
        Equipment equipment = equipmentRepository.findById(id).orElseThrow();
        user.getWishedEquipments().add(equipment);
        return new ResponseEntity<>("git", HttpStatus.OK);
    }
}
