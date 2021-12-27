package com.gunshop.gungame;


import com.gunshop.gungame.model.Equipment;
import com.gunshop.gungame.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentResources {
    private final EquipmentService equipmentService;

    public EquipmentResources(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipment () {
        List<Equipment> equipment = equipmentService.findAllEquipments();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Equipment> addEquipment(@RequestBody Equipment equipment) {
        Equipment newEquipment = equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(newEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment){
        Equipment updateEquipment = equipmentService.updateEquipment(equipment);
        return new ResponseEntity<>(updateEquipment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable("id") Long id){
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}











