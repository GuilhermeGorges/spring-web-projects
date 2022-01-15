package com.guilherme.springwebmvc.repository;

import com.guilherme.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    private List<Jedi> jedi;
    public List<Jedi> getAllJedi(){
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
        return jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);
    }
}
