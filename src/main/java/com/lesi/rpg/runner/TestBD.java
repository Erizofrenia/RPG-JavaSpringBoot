package com.lesi.rpg.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lesi.rpg.entity.PlayerCharacter;
import com.lesi.rpg.repository.PlayerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//@Component 
public class TestBD implements CommandLineRunner {
    //@PersistenceContext
    //private EntityManager entityManager;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional 
    public void run(String... args) throws Exception {
        System.out.println("--PRUEBA DE PERSISTENCIA--");
        System.out.println("--Creando personaje...--");

        PlayerCharacter pj = new PlayerCharacter();
        String pjname="Cuyito";
        pj.setName(pjname);
        pj.setHealth(100);

        playerRepository.save(pj);
        //entityManager.persist(pj);

        System.out.println("Se ha creado el personaje con Repository "+pjname);
        System.out.println("----------------------------------");

        playerRepository.findByName(pjname).ifPresent(player ->{
            System.out.println("Se encontró "+ player.getName() +" en la BD. Nivel: "+player.getLv());
        });
        
    }


    
}
