package com.lesi.rpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lesi.rpg.entity.PlayerCharacter;

@Repository 
public interface PlayerRepository extends JpaRepository<PlayerCharacter, Long>{

    Optional<PlayerCharacter> findByName(String name);

}
