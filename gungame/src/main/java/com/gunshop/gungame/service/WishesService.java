package com.gunshop.gungame.service;

import com.gunshop.gungame.model.Equipment;
import com.gunshop.gungame.model.User;
import com.gunshop.gungame.model.Wishes;
import com.gunshop.gungame.repository.EquipmentRepository;
import com.gunshop.gungame.repository.UserRepository;
import com.gunshop.gungame.repository.WishesRepository;
import com.gunshop.gungame.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class WishesService {

    private final UserRepository userRepository;
    private final EquipmentRepository equipmentRepository;
    private final JwtUtils jwtUtils;
    private final WishesRepository wishesRepository;

    @Autowired
    public WishesService(UserRepository userRepository, EquipmentRepository equipmentRepository, JwtUtils jwtUtils, WishesRepository wishesRepository ){
        this.userRepository = userRepository;
        this.equipmentRepository = equipmentRepository;
        this.jwtUtils = jwtUtils;
        this.wishesRepository = wishesRepository;
    }


//    public ResponseEntity<?> addWish(Long id, String username){
//       UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        username = userDetails.getUsername();
//        User user = userRepository.findByUsername(username).orElseThrow();
//        Equipment equipment = equipmentRepository.findById(id).orElseThrow();
//        user.getWishedEquipments().add(equipment);
//        return new ResponseEntity<>("git", HttpStatus.OK);
//    }


    public List<Wishes> findAllWishes(){
        return wishesRepository.findAll();
    }

    public Wishes addWishes(Wishes wishes){
        return wishesRepository.save(wishes);
    }

    public void deleteWishes(Long id){
        wishesRepository.deleteById(id);
    }



}
