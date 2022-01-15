package com.guilherme.springwebmvc.repository;

import com.guilherme.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    public List<Jedi> getAllJedi(){

        final List<Jedi> jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));

        return jedi;
    }

}
