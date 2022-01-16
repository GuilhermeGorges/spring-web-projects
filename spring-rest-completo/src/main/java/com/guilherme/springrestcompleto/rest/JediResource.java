package com.guilherme.springrestcompleto.rest;

import com.guilherme.springrestcompleto.exception.JediNotFoundException;
import com.guilherme.springrestcompleto.model.Jedi;
import com.guilherme.springrestcompleto.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public Jedi getJediByID(@PathVariable("id") Long id){
        final Optional<Jedi> jedi = repository.findById(id);
        if(jedi.isPresent()) return jedi.get();
        else throw new JediNotFoundException();
    }
}