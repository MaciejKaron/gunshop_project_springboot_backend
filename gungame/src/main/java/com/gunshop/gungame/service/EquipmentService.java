package com.gunshop.gungame.service;

import com.gunshop.gungame.model.Equipment;
import com.gunshop.gungame.repo.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public Equipment addEquipment(Equipment equipment){
        return equipmentRepo.save(equipment);
    }

    public List<Equipment> findAllEquipments(){
        return equipmentRepo.findAll();
    }

    public Equipment updateEquipment(Equipment equipment){
        return equipmentRepo.save(equipment);
    }

//    public void deleteEquipment(Long id){
//        equipmentRepo.deleteEquipmentById(id);
//     }

    public void deleteEquipment(Long id){
        equipmentRepo.deleteById(id);
    }

}

