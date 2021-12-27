package com.gunshop.gungame.repository;

import com.gunshop.gungame.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
    void deleteEquipmentById(Long id);
}
