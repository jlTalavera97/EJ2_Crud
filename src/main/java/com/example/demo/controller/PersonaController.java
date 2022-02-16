package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaImpl personaimpl;

    @GetMapping("/getAll")
    public List<Persona> getPersonas(){
        return personaimpl.getAll();
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Persona persona){
        return personaimpl.addPerson(persona);
    }

    @PutMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable Integer id, @RequestBody Persona persona){
        return personaimpl.updatePerson(id,persona);
    }

    @PostMapping("/deletePerson")
    public String deletePerson(Integer id){
        return personaimpl.deleteById(id);
    }

    @GetMapping("/getUsers/{user}")
    public List<Persona> getUsers(@PathVariable String user){
        return personaimpl.findByUser(user);
    }
}
