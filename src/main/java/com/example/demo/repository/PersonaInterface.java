package com.example.demo.repository;

import com.example.demo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaInterface extends JpaRepository<Persona, Integer>{

    Persona findById(int id_persona);

    @Query("SELECT p FROM Persona p WHERE p.usuario = ?1")
    List<Persona>findByUser(String user);

}
