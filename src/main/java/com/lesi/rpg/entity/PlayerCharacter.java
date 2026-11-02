package com.lesi.rpg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "player_character")
@Data
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false)
    private int lv = 1;

    @Column(nullable = false)
    private long experience = 0;

    @Column(nullable = false)
    private int health = 100;

    @Column(nullable = false)
    private int maxHealth = 100;

    private double positionX = 0.0;
    private double positionY = 0.0;
}
