package com.gunshop.gungame.repository;

import com.gunshop.gungame.model.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishesRepository extends JpaRepository<Wishes, Long> {

    List<Wishes> findByUserId(Long postId);

}
