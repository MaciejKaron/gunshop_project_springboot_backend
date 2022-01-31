package com.gunshop.gungame;

import com.gunshop.gungame.model.Wishes;
import com.gunshop.gungame.repository.WishesRepository;
import com.gunshop.gungame.service.WishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishes")
public class WishesResources {
    private final WishesService wishesService;

    public WishesResources(WishesService wishesService){
        this.wishesService = wishesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Wishes>> getAllWishes(){
        List<Wishes> wishes = wishesService.findAllWishes();
        return new ResponseEntity<>(wishes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Wishes> addWishes(@RequestBody Wishes wishes) {
        Wishes newWishes = wishesService.addWishes(wishes);
        return new ResponseEntity<>(newWishes, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWishes(@PathVariable("id") Long id){
        wishesService.deleteWishes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    WishesRepository wishesRepository;

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Wishes>> getAllMyWishes(@PathVariable(value = "id")Long wishId){
        List<Wishes> wishes = wishesRepository.findByUserId(wishId);
        return new ResponseEntity<>(wishes, HttpStatus.OK);
    }

}
