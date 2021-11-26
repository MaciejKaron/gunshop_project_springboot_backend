package com.gunshop.gungame.repo;

import com.gunshop.gungame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<User,Long> {
}
