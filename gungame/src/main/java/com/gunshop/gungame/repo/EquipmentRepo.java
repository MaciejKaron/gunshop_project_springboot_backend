package com.gunshop.gungame.repo;

import com.gunshop.gungame.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepo extends JpaRepository<Equipment,Long> {
    void deleteEquipmentById(Long id);
}
