package com.gunshop.gungame.repository;

import com.gunshop.gungame.model.ERole;
import com.gunshop.gungame.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
