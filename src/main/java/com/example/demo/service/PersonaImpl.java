package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaImpl {

    @Autowired
    PersonaInterface personaInterface;


    public List<Persona> getAll() {
        return personaInterface.findAll();
    }

    public String addPerson(Persona persona) {
        if (persona.getUsuario().length() >= 6 && persona.getUsuario().length() <= 10) {
            personaInterface.save(persona);
            return "persona con id " + persona.getId_persona() + " añadida con exito.";
        }
        return "La longitud del nombre de usuario debe ser mayor que 6 y menor que 10 caracteres";
    }

    public String updatePerson(int id, Persona p) {

        Persona p1 = personaInterface.findById(id);

        if (p.getId_persona() != null) {
            p1.setId_persona(p.getId_persona());
        }
        if (p.getUsuario() != null) {
            p1.setUsuario(p.getUsuario());
        }
        if (p.getPassword() != null) {
            p1.setPassword(p.getPassword());
        }
        if (p.getName() != null) {
            p1.setName(p.getName());
        }
        if (p.getSurname() != null) {
            p1.setSurname(p.getSurname());
        }
        if (p.getCompany_email() != null) {
            p1.setCompany_email(p.getCompany_email());
        }
        if (p.getPersonal_email() != null) {
            p1.setPersonal_email(p.getPersonal_email());
        }
        if (p.getCity() != null) {
            p1.setCity(p.getCity());
        }
        if (p.getActive() != null) {
            p1.setActive(p.getActive());
        }
        if (p.getCreated_date() != null) {
            p1.setCreated_date(p.getCreated_date());
        }
        if (p.getImagen_url() != null) {
            p1.setImagen_url(p.getImagen_url());
        }
        if (p.getTermination_date() != null) {
            p1.setTermination_date(p.getTermination_date());
        }
        personaInterface.save(personaInterface.findById(id));
        return "Persona actualizada";
    }

    public String deleteById(Integer id) {

        if (personaInterface.findById(id) == null) {
            return "Persona con id " + id + " no encontrada";
        }
        personaInterface.deleteById(id);
        return "Persona con id " + id + " borrada con exito.";
    }

    public Optional<Persona> findById(Integer id) {
        return personaInterface.findById(id);
    }

    public List<Persona> findByUser(String user){
        return personaInterface.findByUser(user);
    }
}


